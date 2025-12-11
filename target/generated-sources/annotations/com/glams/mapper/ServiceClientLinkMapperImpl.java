package com.glams.mapper;

import com.glams.dto.request.ServiceClientLinkRequestDTO;
import com.glams.dto.response.ServiceClientLinkResponseDTO;
import com.glams.model.Client;
import com.glams.model.ServiceClientLink;
import com.glams.model.ServiceProvider;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-11T16:55:20+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ServiceClientLinkMapperImpl implements ServiceClientLinkMapper {

    @Override
    public ServiceClientLink toEntity(ServiceClientLinkRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ServiceClientLink.ServiceClientLinkBuilder serviceClientLink = ServiceClientLink.builder();

        serviceClientLink.client( serviceClientLinkRequestDTOToClient( dto ) );
        serviceClientLink.serviceProvider( serviceClientLinkRequestDTOToServiceProvider( dto ) );

        return serviceClientLink.build();
    }

    @Override
    public ServiceClientLinkResponseDTO toDTO(ServiceClientLink entity) {
        if ( entity == null ) {
            return null;
        }

        ServiceClientLinkResponseDTO.ServiceClientLinkResponseDTOBuilder serviceClientLinkResponseDTO = ServiceClientLinkResponseDTO.builder();

        serviceClientLinkResponseDTO.clientId( entityClientId( entity ) );
        serviceClientLinkResponseDTO.serviceProviderId( entityServiceProviderId( entity ) );
        serviceClientLinkResponseDTO.id( entity.getId() );

        return serviceClientLinkResponseDTO.build();
    }

    protected Client serviceClientLinkRequestDTOToClient(ServiceClientLinkRequestDTO serviceClientLinkRequestDTO) {
        if ( serviceClientLinkRequestDTO == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.id( serviceClientLinkRequestDTO.getClientId() );

        return client.build();
    }

    protected ServiceProvider serviceClientLinkRequestDTOToServiceProvider(ServiceClientLinkRequestDTO serviceClientLinkRequestDTO) {
        if ( serviceClientLinkRequestDTO == null ) {
            return null;
        }

        ServiceProvider.ServiceProviderBuilder serviceProvider = ServiceProvider.builder();

        serviceProvider.id( serviceClientLinkRequestDTO.getServiceProviderId() );

        return serviceProvider.build();
    }

    private Long entityClientId(ServiceClientLink serviceClientLink) {
        Client client = serviceClientLink.getClient();
        if ( client == null ) {
            return null;
        }
        return client.getId();
    }

    private Long entityServiceProviderId(ServiceClientLink serviceClientLink) {
        ServiceProvider serviceProvider = serviceClientLink.getServiceProvider();
        if ( serviceProvider == null ) {
            return null;
        }
        return serviceProvider.getId();
    }
}
