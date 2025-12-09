package com.glams.mapper;

import com.glams.dto.request.RoleRequestDTO;
import com.glams.dto.response.RoleResponseDTO;
import com.glams.model.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T03:07:23+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toEntity(RoleRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.name( dto.getName() );

        return role.build();
    }

    @Override
    public RoleResponseDTO toDto(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();

        roleResponseDTO.setId( entity.getId() );
        roleResponseDTO.setName( entity.getName() );

        return roleResponseDTO;
    }
}
