package com.glams.service;

import com.glams.dto.request.ServiceClientLinkRequestDTO;
import com.glams.dto.response.ServiceClientLinkResponseDTO;

import java.util.List;

public interface ServiceClientLinkService {

    ServiceClientLinkResponseDTO create(ServiceClientLinkRequestDTO dto);

    ServiceClientLinkResponseDTO getServiceClientLinkById(Long id);

    List<ServiceClientLinkResponseDTO> getAllServiceClientLink();

    void delete(Long id);
}
