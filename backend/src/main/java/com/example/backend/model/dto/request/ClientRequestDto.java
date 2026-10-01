package com.example.backend.model.dto.request;

import com.example.backend.model.entity.RolesEntity;
import com.example.backend.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ClientRequestDto {
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Password is required")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*@).{8,}$",
            message = "Password must be at least 8 characters and contain an uppercase letter, a lowercase letter, a number, and @"
    )
    private String password;
    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;

}
