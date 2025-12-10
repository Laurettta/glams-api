package com.glams.dto.response;

import com.glams.enums.RoleName;
import lombok.Data;

import java.time.Instant;

@Data
public class UserRoleResponseDTO {
    private Long id;
    private Long userId;
    private Long roleId;
    private RoleName roleName;
    private Instant createdAt;
    private Instant updatedAt;
}
