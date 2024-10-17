package com.harsh.atd.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationErrorResponse {
    private List<String> message;
    private HttpStatus status;
    private String type;
}
