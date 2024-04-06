package com.kukerton.global.exception;

import com.kukerton.global.enums.MemberErrorCode;

public class ImageException extends RuntimeException{

    MemberErrorCode memberErrorCode;

    public ImageException(MemberErrorCode memberErrorCode) {
        super(memberErrorCode.getErrorMessage());
        this.memberErrorCode = memberErrorCode;
    }
}
