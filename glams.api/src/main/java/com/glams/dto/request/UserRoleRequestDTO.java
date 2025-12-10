package com.glams.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleRequestDTO {

    private Long userId;
    private Long roleId;
    private String roleName;

}
