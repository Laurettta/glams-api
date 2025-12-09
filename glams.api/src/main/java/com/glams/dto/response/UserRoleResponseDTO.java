package com.glams.dto.response;

import lombok.Data;

import java.time.Instant;

@Data
public class UserRoleResponseDTO {
    private Long id;
    private Long userId;
    private Long roleId;
    private Instant createdAt;
    private Instant updatedAt;
}
