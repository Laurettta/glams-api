package com.glams.service;

import com.glams.dto.request.ServiceRequestDTO;
import com.glams.dto.response.ServiceResponseDTO;

import java.util.List;

public interface ServiceService {

    ServiceResponseDTO createService(ServiceRequestDTO dto);

    ServiceResponseDTO getServiceById(Long id);

    List<ServiceResponseDTO> getAllService();

    ServiceResponseDTO updateService(Long id, ServiceRequestDTO dto);

    void deleteService(Long id);
}
