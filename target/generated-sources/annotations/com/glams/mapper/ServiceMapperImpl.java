package com.glams.mapper;

import com.glams.dto.request.ServiceRequestDTO;
import com.glams.dto.response.ServiceResponseDTO;
import com.glams.model.Service;
import com.glams.model.ServiceProvider;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T03:07:23+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public Service toEntity(ServiceRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Service.ServiceBuilder service = Service.builder();

        service.provider( serviceRequestDTOToServiceProvider( dto ) );
        service.category( dto.getCategory() );
        service.name( dto.getName() );
        service.description( dto.getDescription() );
        service.price( dto.getPrice() );
        service.capacity( dto.getCapacity() );
        service.location( dto.getLocation() );

        return service.build();
    }

    @Override
    public ServiceResponseDTO toDTO(Service entity) {
        if ( entity == null ) {
            return null;
        }

        ServiceResponseDTO.ServiceResponseDTOBuilder serviceResponseDTO = ServiceResponseDTO.builder();

        serviceResponseDTO.providerId( entityProviderId( entity ) );
        serviceResponseDTO.id( entity.getId() );
        serviceResponseDTO.category( entity.getCategory() );
        serviceResponseDTO.name( entity.getName() );
        serviceResponseDTO.description( entity.getDescription() );
        serviceResponseDTO.price( entity.getPrice() );
        serviceResponseDTO.capacity( entity.getCapacity() );
        serviceResponseDTO.location( entity.getLocation() );

        return serviceResponseDTO.build();
    }

    @Override
    public void updateFromDto(ServiceRequestDTO dto, Service entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getCategory() != null ) {
            entity.setCategory( dto.getCategory() );
        }
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        entity.setPrice( dto.getPrice() );
        if ( dto.getCapacity() != null ) {
            entity.setCapacity( dto.getCapacity() );
        }
        if ( dto.getLocation() != null ) {
            entity.setLocation( dto.getLocation() );
        }
    }

    protected ServiceProvider serviceRequestDTOToServiceProvider(ServiceRequestDTO serviceRequestDTO) {
        if ( serviceRequestDTO == null ) {
            return null;
        }

        ServiceProvider.ServiceProviderBuilder serviceProvider = ServiceProvider.builder();

        serviceProvider.id( serviceRequestDTO.getProviderId() );

        return serviceProvider.build();
    }

    private Long entityProviderId(Service service) {
        ServiceProvider provider = service.getProvider();
        if ( provider == null ) {
            return null;
        }
        return provider.getId();
    }
}
