package com.glams.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle resource not found exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFound(ResourceNotFoundException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("success", false);
        body.put("message", ex.getMessage());
        body.put("statusCode", HttpStatus.NOT_FOUND.value());
        body.put("timestamp", Instant.now());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    // Handle validation errors from @Valid DTOs
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("success", false);
        body.put("statusCode", HttpStatus.BAD_REQUEST.value());
        body.put("timestamp", Instant.now());

        // Combine all validation messages into one string
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; ")
        );
        body.put("message", errors.toString());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

//    // Handle bad requests
//    @ExceptionHandler(BadRequestException.class)
//    public ResponseEntity<Map<String, Object>> handleBadRequest(BadRequestException ex) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("success", false);
//        body.put("message", ex.getMessage());
//        body.put("statusCode", HttpStatus.BAD_REQUEST.value());
//        body.put("timestamp", Instant.now());
//        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//    }
//
//    // Handle unauthorized access
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<Map<String, Object>> handleAccessDenied(AccessDeniedException ex) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("success", false);
//        body.put("message", ex.getMessage());
//        body.put("statusCode", HttpStatus.UNAUTHORIZED.value());
//        body.put("timestamp", Instant.now());
//        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
//    }

    // Catch-all for unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("success", false);
        body.put("message", ex.getMessage());
        body.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("timestamp", Instant.now());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
