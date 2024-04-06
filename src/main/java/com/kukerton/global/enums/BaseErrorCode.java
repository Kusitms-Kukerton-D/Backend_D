package com.kukerton.global.enums;

import com.kukerton.global.response.ErrorResponse;
import org.springframework.http.HttpStatus;


public interface BaseErrorCode {

    int getErrorCode();

    String getErrorMessage();

    HttpStatus getStatus();

    ErrorResponse getErrorResponse();

}
