package com.glams.mapper;

import com.glams.dto.request.ServiceAvailabilityRequestDTO;
import com.glams.dto.response.ServiceAvailabilityResponseDTO;
import com.glams.model.ServiceAvailability;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ServiceAvailabilityMapper {

    @Mapping(target = "service.id", source = "serviceId")
    ServiceAvailability toEntity(ServiceAvailabilityRequestDTO dto);

    @Mapping(target = "serviceId", source = "service.id")
    ServiceAvailabilityResponseDTO toDTO(ServiceAvailability entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(ServiceAvailabilityRequestDTO dto, @MappingTarget ServiceAvailability entity);
}
