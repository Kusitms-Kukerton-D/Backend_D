package com.kukerton.global.enums;

import com.kukerton.global.response.ErrorResponse;
import org.springframework.http.HttpStatus;

public enum RandomErrorCode implements BaseErrorCode{
    RANDOM_INPUT_FORMAT(700, "올바르지 않은 요청 형식입니다.", HttpStatus.BAD_REQUEST);

    private final int errorCode;
    private final String errorMessage;
    private final HttpStatus status;

    RandomErrorCode(int errorCode, String errorMessage, HttpStatus status) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
    }

    @Override
    public int getErrorCode() {
        return 0;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public HttpStatus getStatus() {
        return null;
    }

    @Override
    public ErrorResponse getErrorResponse() {
        return new ErrorResponse(this.errorCode, this.errorMessage);
    }
}
