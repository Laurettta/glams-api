package com.glams.mapper;

import com.glams.dto.request.ServiceClientLinkRequestDTO;
import com.glams.dto.response.ServiceClientLinkResponseDTO;
import com.glams.model.ServiceClientLink;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceClientLinkMapper {

    @Mapping(target = "client.id", source = "clientId")
    @Mapping(target = "serviceProvider.id", source = "serviceProviderId")
    ServiceClientLink toEntity(ServiceClientLinkRequestDTO dto);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "serviceProviderId", source = "serviceProvider.id")
    ServiceClientLinkResponseDTO toDTO(ServiceClientLink entity);

}
