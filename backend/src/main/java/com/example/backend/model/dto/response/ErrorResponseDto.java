package com.example.backend.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponseDto {
    @JsonFormat(pattern = "dd MMMM yyyy HH:mm:ss" , locale = "fr")
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
