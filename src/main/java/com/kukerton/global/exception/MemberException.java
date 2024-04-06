package com.kukerton.global.exception;

import com.kukerton.global.enums.MemberErrorCode;
import lombok.Getter;

@Getter
public class MemberException extends RuntimeException{

    private final MemberErrorCode errorCode;

    public MemberException(MemberErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

}
