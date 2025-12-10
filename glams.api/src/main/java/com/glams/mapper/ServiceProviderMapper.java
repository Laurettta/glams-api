package com.glams.mapper;

import com.glams.dto.request.ServiceProviderRequestDTO;
import com.glams.dto.response.ServiceProviderResponseDTO;
import com.glams.model.ServiceProvider;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ServiceProviderMapper {

    ServiceProvider toEntity(ServiceProviderRequestDTO dto);

    @org.mapstruct.Mapping(source = "user.id", target = "userId")
    ServiceProviderResponseDTO toDTO(ServiceProvider entity);

    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateServiceProviderFromDto(ServiceProviderRequestDTO dto, @MappingTarget ServiceProvider entity);
}
