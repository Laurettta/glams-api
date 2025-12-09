package com.glams.service;

import com.glams.dto.request.ServiceProviderRequestDTO;
import com.glams.dto.response.ServiceProviderResponseDTO;

import java.util.List;

public interface ServiceProviderService {

    ServiceProviderResponseDTO create (ServiceProviderRequestDTO requestDTO);

    ServiceProviderResponseDTO getServiceProviderById (Long id);

    List<ServiceProviderResponseDTO> getAllServiceProvider();

    ServiceProviderResponseDTO updateServiceProvider(Long id, ServiceProviderRequestDTO requestDTO);

    void delete (Long id);
}
