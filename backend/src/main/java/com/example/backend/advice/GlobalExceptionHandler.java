package com.example.backend.advice;

import com.example.backend.exception.*;
import com.example.backend.model.dto.response.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger  = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidCredentialsException(InvalidCredentialsException ex , HttpServletRequest request) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.UNAUTHORIZED.value())
                .error(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponseDto);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex , HttpServletRequest request) {
        ErrorResponseDto error = ErrorResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(ConflictStateException.class)
    public ResponseEntity<ErrorResponseDto> handleConflictStateException(ConflictStateException ex , HttpServletRequest request) {
        ErrorResponseDto error = ErrorResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .error(HttpStatus.CONFLICT.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGenericException(Exception ex , HttpServletRequest request) {
        ErrorResponseDto error = ErrorResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String , String>> handleRuntimeException(RuntimeException ex){
        logger.error("Unexpected error occurred: {}", ex.getMessage(), ex);
        Map<String, String> response = new HashMap<>();
        response.put("error",ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }

}
