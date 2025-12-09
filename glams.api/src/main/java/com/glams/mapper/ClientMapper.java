package com.glams.mapper;

import com.glams.dto.request.ClientRequestDTO;
import com.glams.dto.response.ClientResponseDTO;
import com.glams.model.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "user.id", source = "userId")
    Client toEntity(ClientRequestDTO dto);

    @Mapping(target = "userId", source = "user.id")
    ClientResponseDTO toDto(Client client);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(ClientRequestDTO dto, @MappingTarget Client client);
}
