package com.harsh.atd.exception;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.harsh.atd.response.ErrorResponse;
import com.harsh.atd.response.ValidationErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = ErrorResponse.builder().status(httpStatus).message(e.getMessage())
                .type("MySql").build();

        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        List<String> errors = e.getFieldErrors().stream().map(error -> error.getDefaultMessage()).toList();
        ValidationErrorResponse validationErrorResponse = ValidationErrorResponse.builder().message(errors)
                .status(httpStatus).type("Validation").build();

        return ResponseEntity.status(httpStatus).body(validationErrorResponse);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(
            NoSuchElementException e) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponse errorResponse = ErrorResponse.builder().message(e.getMessage()).status(httpStatus)
                .type("Database").build();

        return ResponseEntity.status(httpStatus).body(errorResponse);
    }
    
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
