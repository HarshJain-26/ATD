package com.harsh.atd.curd.db.response;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private HttpStatus status;
    private String type;
}
