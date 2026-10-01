package com.example.backend.service;

import com.example.backend.model.dto.request.ClientRequestDto;
import com.example.backend.model.dto.response.AuthResponseDto;
import com.example.backend.model.dto.response.detail.ClientResponseDetailDto;

public interface AuthService {
    ClientResponseDetailDto registerClient(ClientRequestDto clientRequestDto);
}
