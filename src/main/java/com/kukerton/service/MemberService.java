package com.kukerton.service;


import com.kukerton.domain.entity.Member;
import com.kukerton.domain.repository.MemberRepository;
import com.kukerton.dto.response.KakaoAccessToken;
import com.kukerton.dto.response.KakaoUserInfo;
import com.kukerton.global.enums.MemberErrorCode;
import com.kukerton.global.exception.MemberException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    private final String clientId = "5cd984f686b2785bcc5e6f25ecbbc27d";
    private final String redirectUrl = "http://localhost:5173/auth";
    private final String clientSecret = "OswNgBtjAgVLXQbc92J1syZvXVWKizr8";
    private final String contentType = "application/x-www-form-urlencoded;charset=utf-8";

    public String getAccessToken(String authCode) {  // token 받아옴 ( 네이티브 앱에서는 필요 x )

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();

        requestBody.add("grant_type", "authorization_code");
        requestBody.add("client_id", clientId);
        requestBody.add("redirect_uri", redirectUrl);
        requestBody.add("code", authCode);
        requestBody.add("client_secret", clientSecret);

        WebClient webclient = WebClient.builder()
            .baseUrl("https://kauth.kakao.com")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, contentType)
            .build();

        //access token 요청
        KakaoAccessToken responseToken = webclient.post()
            .uri(uriBuilder -> uriBuilder
                .path("/oauth/token")
                .queryParams(requestBody)
                .build())
            .exchangeToMono(response -> {
                if (response.statusCode().equals(HttpStatus.OK)) {
                    return response.bodyToMono(KakaoAccessToken.class);
                } else if (response.statusCode().is4xxClientError()) { // 4xx 에러 handle
                    throw new MemberException(MemberErrorCode.OAUTH_ACCECC_TOKEN_400);
                } else if (response.statusCode().is5xxServerError()) { // 5xx 에러 handle
                    throw new MemberException(MemberErrorCode.OAUTH_ACCECC_TOKEN_500);
                } else {
                    throw new RuntimeException("webclient error"); // 그 외 에러 handle
                }
            }).block(); // 동기 처리
        return responseToken.accessToken();
    }

    @Transactional
    public Long getUserInfoFromResourceServer(String authCode) {  // 사용자 정보 받아옴

        String token = getAccessToken(authCode);

        WebClient webclient = WebClient.builder()
            .baseUrl("https://kapi.kakao.com/v2/user/me")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, contentType)
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
            .build();

        //kakao resource server로 사용자 정보 요청
        KakaoUserInfo userInfo = webclient.post()
            .accept(MediaType.APPLICATION_JSON)
            .exchangeToMono(response -> {
                if (response.statusCode().equals(HttpStatus.OK)) {
                    return response.bodyToMono(KakaoUserInfo.class);
                } else if (response.statusCode().is4xxClientError()) { // 4xx 에러 handle
                    throw new MemberException(MemberErrorCode.KAKAO_USERINFO_400);
                } else if (response.statusCode().is5xxServerError()) { // 5xx 에러 handle
                    throw new MemberException(MemberErrorCode.KAKAO_USERINFO_500);
                } else {
                    throw new RuntimeException("webclient error"); // 그 외 에러 handle
                }
            }).block();

        Optional<Member> member = isMember(userInfo.authId());

        if (member.isPresent()) { // 기존회원은 바로 로그인 처리
            return member.get().getId();
        }

        // 비회원임으로 회원가입 처리 후 로그인 처리
        // 회원 가입
        Member newMember = userInfo.toEntity(userInfo);
        memberRepository.save(newMember);
        // 로그인
        return newMember.getId();

    }

    public Optional<Member> isMember(Long authId) {

        return memberRepository.findByAuthId(authId);

    }


}
