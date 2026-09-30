package com.example.backend.model.dto.response;

import com.example.backend.model.enums.Role;
import lombok.Data;

@Data
public class AuthResponseDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String accessToken;
}
