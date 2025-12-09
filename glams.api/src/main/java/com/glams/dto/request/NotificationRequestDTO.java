package com.glams.dto.request;

import com.glams.enums.NotificationStatus;
import com.glams.enums.NotificationType;
import lombok.Data;

@Data
public class NotificationRequestDTO {

    private Long userId;
    private String message;
    private NotificationType type;
    private NotificationStatus status;
}
