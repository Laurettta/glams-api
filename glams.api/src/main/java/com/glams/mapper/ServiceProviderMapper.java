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

    ServiceProviderResponseDTO toDTO(ServiceProvider entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateServiceProviderFromDto(ServiceProviderRequestDTO dto, @MappingTarget ServiceProvider entity);
}
