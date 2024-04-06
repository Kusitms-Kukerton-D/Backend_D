package com.kukerton.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kukerton.domain.entity.Member;
import jakarta.validation.constraints.NotNull;


public record KakaoUserInfo(
    @JsonProperty("id")
    @NotNull(message = "authId는 필수입니다.")
    Long authId,
    @JsonProperty("kakao_account")
    @NotNull(message = "kakaoAccount는 필수입니다.")
    KakaoAccount kakaoAccount
) {

    public Member toEntity(KakaoUserInfo userInfo) {
        return Member.builder()
            .nickname(userInfo.kakaoAccount.profile().nickname())
            .authId(userInfo.authId)
            .build();
    }
}
