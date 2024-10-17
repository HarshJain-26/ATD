package com.harsh.atd.curd.fs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.harsh.atd.curd.fs.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(NoResourceFoundException.class)
        public ResponseEntity<ErrorResponse> handleNoResourceFoundException(
                        NoResourceFoundException e) {

                HttpStatus httpStatus = HttpStatus.NOT_FOUND;
                ErrorResponse errorResponse = ErrorResponse.builder().message(e.getMessage()).status(httpStatus)
                                .type("Resource").build();

                return ResponseEntity.status(httpStatus).body(errorResponse);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleException(
                        Exception e) {

                HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;
                ErrorResponse errorResponse = ErrorResponse.builder().message(e.getMessage()).status(httpStatus)
                                .type("Default").build();

                return ResponseEntity.status(httpStatus).body(errorResponse);
        }

}
