package com.example.backend.service.impl;

import com.example.backend.exception.ConflictStateException;
import com.example.backend.exception.InvalidCredentialsException;
import com.example.backend.mapper.ClientMapper;
import com.example.backend.model.dto.request.ClientRequestDto;
import com.example.backend.model.dto.response.AuthResponseDto;
import com.example.backend.model.dto.response.detail.ClientResponseDetailDto;
import com.example.backend.model.entity.Client;
import com.example.backend.repository.ClientRepository;
import com.example.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    @Override
    public ClientResponseDetailDto registerClient(ClientRequestDto clientRequestDto) {
     if(clientRepository.findByEmail(clientRequestDto.getEmail()).isPresent()){
        throw new ConflictStateException("Email already exists");
    }
     if(clientRepository.findByPhoneNumber(clientRequestDto.getPhoneNumber()).isPresent()) {
         throw new ConflictStateException("Phone number already exists");
     }
     String password = clientRequestDto.getPassword();
     if (password == null
             || password.isBlank()
             || password.length() < 8
             || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*@).{8,}$")) {
         throw new InvalidCredentialsException(
                 "Password must be at least 8 characters and contain an uppercase letter, a lowercase letter, a number, and @");
     }
     if(!password.equals(clientRequestDto.getConfirmPassword())){
         throw new InvalidCredentialsException("Password and confirm password do not match");
     }
//     String salt = BCrypt.gensalt();
//     String hashedPassword = BCrypt.hashpw(password, salt);
//     clientRequestDto.setPassword(hashedPassword);
     Client client = clientMapper.toEntity(clientRequestDto);
     return clientMapper.toClientDetail(clientRepository.save(client));
}

}
