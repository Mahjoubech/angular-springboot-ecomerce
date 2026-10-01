package com.example.backend.controller;

import com.example.backend.model.dto.request.ClientRequestDto;
import com.example.backend.model.dto.response.detail.ClientResponseDetailDto;
import com.example.backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ClientResponseDetailDto> registerClient(@Valid @RequestBody ClientRequestDto requestDto){
        ClientResponseDetailDto client = authService.registerClient(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }
}
