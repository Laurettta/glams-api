package com.glams.mapper;

import com.glams.dto.request.ServiceAvailabilityRequestDTO;
import com.glams.dto.response.ServiceAvailabilityResponseDTO;
import com.glams.model.Service;
import com.glams.model.ServiceAvailability;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-11T16:55:20+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ServiceAvailabilityMapperImpl implements ServiceAvailabilityMapper {

    @Override
    public ServiceAvailability toEntity(ServiceAvailabilityRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ServiceAvailability.ServiceAvailabilityBuilder serviceAvailability = ServiceAvailability.builder();

        serviceAvailability.service( serviceAvailabilityRequestDTOToService( dto ) );
        serviceAvailability.availableDate( dto.getAvailableDate() );
        serviceAvailability.startTime( dto.getStartTime() );
        serviceAvailability.endTime( dto.getEndTime() );
        serviceAvailability.isAvailable( dto.getIsAvailable() );

        return serviceAvailability.build();
    }

    @Override
    public ServiceAvailabilityResponseDTO toDTO(ServiceAvailability entity) {
        if ( entity == null ) {
            return null;
        }

        ServiceAvailabilityResponseDTO.ServiceAvailabilityResponseDTOBuilder serviceAvailabilityResponseDTO = ServiceAvailabilityResponseDTO.builder();

        serviceAvailabilityResponseDTO.serviceId( entityServiceId( entity ) );
        serviceAvailabilityResponseDTO.id( entity.getId() );
        serviceAvailabilityResponseDTO.availableDate( entity.getAvailableDate() );
        serviceAvailabilityResponseDTO.startTime( entity.getStartTime() );
        serviceAvailabilityResponseDTO.endTime( entity.getEndTime() );
        serviceAvailabilityResponseDTO.isAvailable( entity.getIsAvailable() );

        return serviceAvailabilityResponseDTO.build();
    }

    @Override
    public void updateFromDto(ServiceAvailabilityRequestDTO dto, ServiceAvailability entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getAvailableDate() != null ) {
            entity.setAvailableDate( dto.getAvailableDate() );
        }
        if ( dto.getStartTime() != null ) {
            entity.setStartTime( dto.getStartTime() );
        }
        if ( dto.getEndTime() != null ) {
            entity.setEndTime( dto.getEndTime() );
        }
        if ( dto.getIsAvailable() != null ) {
            entity.setIsAvailable( dto.getIsAvailable() );
        }
    }

    protected Service serviceAvailabilityRequestDTOToService(ServiceAvailabilityRequestDTO serviceAvailabilityRequestDTO) {
        if ( serviceAvailabilityRequestDTO == null ) {
            return null;
        }

        Service.ServiceBuilder service = Service.builder();

        service.id( serviceAvailabilityRequestDTO.getServiceId() );

        return service.build();
    }

    private Long entityServiceId(ServiceAvailability serviceAvailability) {
        Service service = serviceAvailability.getService();
        if ( service == null ) {
            return null;
        }
        return service.getId();
    }
}
