package com.kukerton.global.exception;

import com.kukerton.global.enums.CertificationErrorCode;
import lombok.Getter;

@Getter
public class CertificationException extends RuntimeException{

    CertificationErrorCode errorCode;

    public CertificationException(CertificationErrorCode errorCode){
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

}
