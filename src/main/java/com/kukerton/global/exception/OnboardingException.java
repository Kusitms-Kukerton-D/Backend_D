package com.kukerton.global.exception;

import com.kukerton.global.enums.MemberErrorCode;
import lombok.Getter;

@Getter
public class OnboardingException extends RuntimeException{
    private final MemberErrorCode errorCode;

    public OnboardingException(MemberErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }
}
