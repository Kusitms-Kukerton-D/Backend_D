package com.kukerton.global.exception;

import com.kukerton.global.enums.MemberErrorCode;
import com.kukerton.global.enums.RandomErrorCode;
import lombok.Getter;

@Getter
public class RandomException extends RuntimeException{
    private final RandomErrorCode errorCode;

    public RandomException(RandomErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }
}
