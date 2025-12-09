package com.glams.mapper;

import com.glams.dto.request.ServiceRequestDTO;
import com.glams.dto.response.ServiceResponseDTO;
import com.glams.model.Service;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    @Mapping(target = "provider.id", source = "providerId")
    Service toEntity(ServiceRequestDTO dto);

    @Mapping(target = "providerId", source = "provider.id")
    ServiceResponseDTO toDTO(Service entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(ServiceRequestDTO dto, @MappingTarget Service entity);
}
