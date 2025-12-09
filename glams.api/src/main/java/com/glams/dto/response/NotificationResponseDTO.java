package com.glams.dto.response;

import com.glams.enums.NotificationStatus;
import com.glams.enums.NotificationType;
import lombok.Data;

@Data
public class NotificationResponseDTO {

    private Long id;
    private Long userId;
    private String message;
    private NotificationType type;
    private NotificationStatus status;

}
