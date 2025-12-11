package com.glams.mapper;

import com.glams.dto.request.NotificationRequestDTO;
import com.glams.dto.response.NotificationResponseDTO;
import com.glams.model.Notification;
import com.glams.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-11T16:55:20+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public Notification toEntity(NotificationRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Notification.NotificationBuilder notification = Notification.builder();

        notification.user( notificationRequestDTOToUser( dto ) );
        notification.message( dto.getMessage() );
        notification.type( dto.getType() );
        notification.status( dto.getStatus() );

        return notification.build();
    }

    @Override
    public NotificationResponseDTO toDto(Notification entity) {
        if ( entity == null ) {
            return null;
        }

        NotificationResponseDTO notificationResponseDTO = new NotificationResponseDTO();

        notificationResponseDTO.setUserId( entityUserId( entity ) );
        notificationResponseDTO.setId( entity.getId() );
        notificationResponseDTO.setMessage( entity.getMessage() );
        notificationResponseDTO.setType( entity.getType() );
        notificationResponseDTO.setStatus( entity.getStatus() );

        return notificationResponseDTO;
    }

    protected User notificationRequestDTOToUser(NotificationRequestDTO notificationRequestDTO) {
        if ( notificationRequestDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( notificationRequestDTO.getUserId() );

        return user.build();
    }

    private Long entityUserId(Notification notification) {
        User user = notification.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }
}
