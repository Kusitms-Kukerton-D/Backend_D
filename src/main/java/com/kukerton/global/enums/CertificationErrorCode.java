package com.kukerton.global.enums;

import com.kukerton.global.response.ErrorResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CertificationErrorCode implements BaseErrorCode {
    NOT_FOUND(400, "존재하지 않는 certification id입니다.", HttpStatus.BAD_REQUEST);
    private final int errorCode;
    private final String errorMessage;
    private final HttpStatus status;

    CertificationErrorCode(int errorCode, String errorMessage, HttpStatus status) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
    }

    @Override
    public ErrorResponse getErrorResponse() {
        return new ErrorResponse(this.errorCode, this.errorMessage);
    }
}
