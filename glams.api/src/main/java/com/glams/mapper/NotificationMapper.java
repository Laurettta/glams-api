package com.glams.mapper;

import com.glams.dto.request.NotificationRequestDTO;
import com.glams.dto.response.NotificationResponseDTO;
import com.glams.model.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    @Mapping(target = "user.id", source = "userId")
    Notification toEntity(NotificationRequestDTO dto);

    @Mapping(target = "userId", source = "user.id")
    NotificationResponseDTO toDto(Notification entity);
}
