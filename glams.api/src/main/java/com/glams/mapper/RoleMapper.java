package com.glams.mapper;

import com.glams.dto.request.RoleRequestDTO;
import com.glams.dto.response.RoleResponseDTO;
import com.glams.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleRequestDTO dto);

    RoleResponseDTO toDto (Role entity);
}
