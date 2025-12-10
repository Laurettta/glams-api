package com.glams.mapper;

import com.glams.dto.request.UserRequestDTO;
import com.glams.dto.response.UserResponseDTO;
import com.glams.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-10T02:00:08+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.fullName( dto.getFullName() );
        user.email( dto.getEmail() );
        user.password( dto.getPassword() );
        user.phoneNumber( dto.getPhoneNumber() );
        user.status( dto.getStatus() );

        return user.build();
    }

    @Override
    public UserResponseDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTO.UserResponseDTOBuilder userResponseDTO = UserResponseDTO.builder();

        userResponseDTO.roles( mapRolesToRoleNames( user.getRoles() ) );
        userResponseDTO.id( user.getId() );
        userResponseDTO.fullName( user.getFullName() );
        userResponseDTO.email( user.getEmail() );
        userResponseDTO.phoneNumber( user.getPhoneNumber() );
        userResponseDTO.status( user.getStatus() );
        userResponseDTO.isEmailVerified( user.getIsEmailVerified() );

        return userResponseDTO.build();
    }

    @Override
    public void updateUserFromDto(UserRequestDTO dto, User user) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getFullName() != null ) {
            user.setFullName( dto.getFullName() );
        }
        if ( dto.getEmail() != null ) {
            user.setEmail( dto.getEmail() );
        }
        if ( dto.getPassword() != null ) {
            user.setPassword( dto.getPassword() );
        }
        if ( dto.getPhoneNumber() != null ) {
            user.setPhoneNumber( dto.getPhoneNumber() );
        }
        if ( dto.getStatus() != null ) {
            user.setStatus( dto.getStatus() );
        }
    }
}
