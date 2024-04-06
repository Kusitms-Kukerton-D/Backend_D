package com.kukerton.global.enums;

import com.kukerton.global.response.ErrorResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MemberErrorCode implements BaseErrorCode{

    OAUTH_ACCECC_TOKEN_500(500,"소셜 로그인 토큰 발급 에러입니다.",HttpStatus.INTERNAL_SERVER_ERROR),
    OAUTH_ACCECC_TOKEN_400(500,"소셜 로그인 토큰 발급 에러입니다.",HttpStatus.INTERNAL_SERVER_ERROR),
    KAKAO_USERINFO_400(400,"소셜 로그인 토큰 발급 에러입니다.",HttpStatus.INTERNAL_SERVER_ERROR),
    KAKAO_USERINFO_500(500,"소셜 로그인 토큰 발급 에러입니다.",HttpStatus.INTERNAL_SERVER_ERROR),
    IMAGE_FILE_FORM(400,"이미지 형태 에러입니다.",HttpStatus.BAD_REQUEST),
    ONBOARDING_INPUT_FORMAT(600, "올바르지 않은 요청 형식입니다.", HttpStatus.BAD_REQUEST),
    MEMBER_NOT_FOUND(404,"존재하지 않는 회원입니다.",HttpStatus.NOT_FOUND);

    private final int errorCode;
    private final String errorMessage;
    private final HttpStatus status;

    MemberErrorCode(int errorCode, String message, HttpStatus status) {
        this.errorCode = errorCode;
        this.errorMessage = message;
        this.status = status;
    }

    @Override
    public ErrorResponse getErrorResponse() {
        return new ErrorResponse(this.errorCode, this.errorMessage);
    }
}
