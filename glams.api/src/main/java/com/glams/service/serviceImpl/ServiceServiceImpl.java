package com.glams.service.serviceImpl;

import com.glams.dto.request.ServiceRequestDTO;
import com.glams.dto.response.ServiceResponseDTO;
import com.glams.mapper.ServiceMapper;
import com.glams.model.ServiceProvider;
import com.glams.repository.ServiceProviderRepository;
import com.glams.repository.ServiceRepository;
import com.glams.service.ServiceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.glams.model.Service;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository repository;
    private final ServiceProviderRepository providerRepository;
    private final ServiceMapper mapper;

    @Override
    public ServiceResponseDTO createService(ServiceRequestDTO dto) {
        ServiceProvider provider = providerRepository.findById(dto.getProviderId())
                .orElseThrow(() -> new EntityNotFoundException("Provider not found"));

        Service entity = Service.builder()
                .provider(provider)
                .category(dto.getCategory())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .capacity(dto.getCapacity())
                .location(dto.getLocation())
                .build();

        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public ServiceResponseDTO getServiceById(Long id) {
        Service entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public List<ServiceResponseDTO> getAllService() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public ServiceResponseDTO updateService(Long id, ServiceRequestDTO dto) {
        Service entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service not found"));
        mapper.updateFromDto(dto, entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void deleteService(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Service not found");
        }
        repository.deleteById(id);
    }
}
