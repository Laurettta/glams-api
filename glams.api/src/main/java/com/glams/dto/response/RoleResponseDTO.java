package com.glams.dto.response;

import com.glams.enums.RoleName;
import lombok.Data;

@Data
public class RoleResponseDTO {

    private Long id;
    private RoleName name;
}
