package com.glams.service;

import com.glams.dto.request.ServiceAvailabilityRequestDTO;
import com.glams.dto.response.ServiceAvailabilityResponseDTO;

import java.util.List;

public interface ServiceAvailabilityService {

    ServiceAvailabilityResponseDTO create(ServiceAvailabilityRequestDTO dto);

    ServiceAvailabilityResponseDTO getServiceAvailabilityById(Long id);

    List<ServiceAvailabilityResponseDTO> getAllServiceAvailability();

    ServiceAvailabilityResponseDTO updateServiceAvailability(Long id, ServiceAvailabilityRequestDTO dto);

    void delete(Long id);
}
