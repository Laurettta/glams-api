package com.glams.mapper;

import com.glams.dto.response.UserRoleResponseDTO;
import com.glams.enums.RoleName;
import com.glams.model.Role;
import com.glams.model.User;
import com.glams.model.UserRole;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-10T02:59:25+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public UserRoleResponseDTO toDTO(UserRole entity) {
        if ( entity == null ) {
            return null;
        }

        UserRoleResponseDTO userRoleResponseDTO = new UserRoleResponseDTO();

        userRoleResponseDTO.setUserId( entityUserId( entity ) );
        userRoleResponseDTO.setRoleId( entityRoleId( entity ) );
        userRoleResponseDTO.setRoleName( entityRoleName( entity ) );
        userRoleResponseDTO.setId( entity.getId() );
        userRoleResponseDTO.setCreatedAt( entity.getCreatedAt() );
        userRoleResponseDTO.setUpdatedAt( entity.getUpdatedAt() );

        return userRoleResponseDTO;
    }

    private Long entityUserId(UserRole userRole) {
        User user = userRole.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    private Long entityRoleId(UserRole userRole) {
        Role role = userRole.getRole();
        if ( role == null ) {
            return null;
        }
        return role.getId();
    }

    private RoleName entityRoleName(UserRole userRole) {
        Role role = userRole.getRole();
        if ( role == null ) {
            return null;
        }
        return role.getName();
    }
}
