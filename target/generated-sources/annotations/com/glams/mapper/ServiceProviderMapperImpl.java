package com.glams.mapper;

import com.glams.dto.request.ServiceProviderRequestDTO;
import com.glams.dto.response.ServiceProviderResponseDTO;
import com.glams.model.ServiceProvider;
import com.glams.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-10T02:29:04+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ServiceProviderMapperImpl implements ServiceProviderMapper {

    @Override
    public ServiceProvider toEntity(ServiceProviderRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ServiceProvider.ServiceProviderBuilder serviceProvider = ServiceProvider.builder();

        serviceProvider.businessName( dto.getBusinessName() );
        serviceProvider.businessAddress( dto.getBusinessAddress() );
        serviceProvider.description( dto.getDescription() );

        return serviceProvider.build();
    }

    @Override
    public ServiceProviderResponseDTO toDTO(ServiceProvider entity) {
        if ( entity == null ) {
            return null;
        }

        ServiceProviderResponseDTO.ServiceProviderResponseDTOBuilder serviceProviderResponseDTO = ServiceProviderResponseDTO.builder();

        serviceProviderResponseDTO.userId( entityUserId( entity ) );
        serviceProviderResponseDTO.id( entity.getId() );
        serviceProviderResponseDTO.businessName( entity.getBusinessName() );
        serviceProviderResponseDTO.businessAddress( entity.getBusinessAddress() );
        serviceProviderResponseDTO.description( entity.getDescription() );

        return serviceProviderResponseDTO.build();
    }

    @Override
    public void updateServiceProviderFromDto(ServiceProviderRequestDTO dto, ServiceProvider entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getBusinessName() != null ) {
            entity.setBusinessName( dto.getBusinessName() );
        }
        if ( dto.getBusinessAddress() != null ) {
            entity.setBusinessAddress( dto.getBusinessAddress() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
    }

    private Long entityUserId(ServiceProvider serviceProvider) {
        User user = serviceProvider.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }
}
