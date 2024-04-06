package com.kukerton.global.exception;

import static io.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;

import com.kukerton.global.enums.MemberErrorCode;
import com.kukerton.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Member RunTime Handler
     */
    @ExceptionHandler(MemberException.class)
    protected ResponseEntity<ErrorResponse> handleMemberException(MemberException ex) {
        log.warn(">>>>> MemberException : {}", ex);
        MemberErrorCode errorCode = ex.getErrorCode();
        return ResponseEntity.status(errorCode.getStatus()).body(errorCode.getErrorResponse());
    }

}
