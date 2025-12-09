package com.glams.service.serviceImpl;

import com.glams.dto.request.ServiceAvailabilityRequestDTO;
import com.glams.dto.response.ServiceAvailabilityResponseDTO;
import com.glams.mapper.ServiceAvailabilityMapper;
import com.glams.model.ServiceAvailability;
import com.glams.repository.ServiceAvailabilityRepository;
import com.glams.repository.ServiceRepository;
import com.glams.service.ServiceAvailabilityService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.glams.model.Service;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceAvailabilityServiceImpl implements ServiceAvailabilityService {

    private final ServiceAvailabilityRepository repository;
    private final ServiceRepository serviceRepository;
    private final ServiceAvailabilityMapper mapper;

    @Override
    public ServiceAvailabilityResponseDTO create(ServiceAvailabilityRequestDTO dto) {

        if (repository.existsByServiceIdAndAvailableDateAndStartTimeAndEndTime(
                dto.getServiceId(), dto.getAvailableDate(), dto.getStartTime(), dto.getEndTime())) {
            throw new IllegalArgumentException("Availability already exists for this service at the specified time");
        }

        Service service = serviceRepository.findById(dto.getServiceId())
                .orElseThrow(() -> new EntityNotFoundException("Service not found"));

        ServiceAvailability entity = ServiceAvailability.builder()
                .service(service)
                .availableDate(dto.getAvailableDate())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .isAvailable(dto.getIsAvailable())
                .build();

        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public ServiceAvailabilityResponseDTO getServiceAvailabilityById(Long id) {
        ServiceAvailability entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ServiceAvailability not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public List<ServiceAvailabilityResponseDTO> getAllServiceAvailability() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public ServiceAvailabilityResponseDTO updateServiceAvailability(Long id, ServiceAvailabilityRequestDTO dto) {
        ServiceAvailability entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ServiceAvailability not found"));

        mapper.updateFromDto(dto, entity);

        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("ServiceAvailability not found");
        }
        repository.deleteById(id);
    }
}
