package com.glams.mapper;

import com.glams.dto.request.ClientRequestDTO;
import com.glams.dto.response.ClientResponseDTO;
import com.glams.model.Client;
import com.glams.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-10T01:02:48+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toEntity(ClientRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.user( clientRequestDTOToUser( dto ) );

        return client.build();
    }

    @Override
    public ClientResponseDTO toDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();

        clientResponseDTO.setUserId( clientUserId( client ) );
        clientResponseDTO.setId( client.getId() );

        return clientResponseDTO;
    }

    @Override
    public void updateFromDto(ClientRequestDTO dto, Client client) {
        if ( dto == null ) {
            return;
        }
    }

    protected User clientRequestDTOToUser(ClientRequestDTO clientRequestDTO) {
        if ( clientRequestDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( clientRequestDTO.getUserId() );

        return user.build();
    }

    private Long clientUserId(Client client) {
        User user = client.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }
}
