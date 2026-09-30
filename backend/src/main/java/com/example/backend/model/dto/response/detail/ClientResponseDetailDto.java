package com.example.backend.model.dto.response.detail;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClientResponseDetailDto {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
}
