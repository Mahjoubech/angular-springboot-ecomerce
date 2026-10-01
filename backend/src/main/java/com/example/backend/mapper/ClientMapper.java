package com.example.backend.mapper;

import com.example.backend.model.dto.request.ClientRequestDto;
import com.example.backend.model.dto.response.basic.ClientResponseBasicDto;
import com.example.backend.model.dto.response.detail.ClientResponseDetailDto;
import com.example.backend.model.entity.Client;
import com.example.backend.repository.ClientRepository;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "role" , ignore = true)
    Client toEntity(ClientRequestDto clientRequestDto);
    @Mapping(target = "fullName" , expression = "java(client.getFirstName() + \" \" + client.getLastName())")
    ClientResponseBasicDto toClientBasic(Client client);
    ClientResponseDetailDto toClientDetail(Client client);
}
