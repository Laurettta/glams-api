package com.glams.mapper;

import com.glams.dto.request.UserRoleRequestDTO;
import com.glams.dto.response.UserRoleResponseDTO;
import com.glams.model.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

//    @Mapping(target = "user.id", source = "userId")
//    @Mapping(target = "role.id", source = "roleId")
//    UserRole toEntity(UserRoleRequestDTO dto);

    // Only map entity to DTO
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "roleId", source = "role.id")
    UserRoleResponseDTO toDTO(UserRole entity);
}
