package com.glams.service.serviceImpl;

import com.glams.dto.request.ServiceProviderRequestDTO;
import com.glams.dto.response.ServiceProviderResponseDTO;
import com.glams.exception.ResourceNotFoundException;
import com.glams.mapper.ServiceProviderMapper;
import com.glams.model.ServiceProvider;
import com.glams.model.User;
import com.glams.repository.ServiceProviderRepository;
import com.glams.repository.UserRepository;
import com.glams.service.ServiceProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceProviderServiceImpl implements ServiceProviderService {

    private final ServiceProviderRepository serviceProviderRepository;
    private final ServiceProviderMapper serviceProviderMapper;
    private final UserRepository userRepository;


    @Override
    public ServiceProviderResponseDTO create(ServiceProviderRequestDTO dto) {
        // Fetch user from DB
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + dto.getUserId()));

        // Build entity
        ServiceProvider sp = ServiceProvider.builder()
                .user(user)
                .businessName(dto.getBusinessName())
                .businessAddress(dto.getBusinessAddress())
                .description(dto.getDescription())
                .build();

        // Save entity
        ServiceProvider saved = serviceProviderRepository.save(sp);

        // Map to response DTO
        return ServiceProviderResponseDTO.builder()
                .id(saved.getId())
                .userId(saved.getUser().getId())  // extract user ID
                .businessName(saved.getBusinessName())
                .businessAddress(saved.getBusinessAddress())
                .description(saved.getDescription())
                .build();
    }


    @Override
    public ServiceProviderResponseDTO getServiceProviderById (Long id){
        ServiceProvider provider = serviceProviderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service Provider not found"));
        return serviceProviderMapper.toDTO(provider);
    }

    @Override
    public List<ServiceProviderResponseDTO> getAllServiceProvider() {
        return serviceProviderRepository.findAll()
                .stream()
                .map(serviceProviderMapper::toDTO)
                .toList();
    }

    @Override
    public ServiceProviderResponseDTO updateServiceProvider(Long id, ServiceProviderRequestDTO dto) {
        ServiceProvider entity = serviceProviderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service Provider not found"));

        serviceProviderMapper.updateServiceProviderFromDto(dto, entity);

        ServiceProvider updated = serviceProviderRepository.save(entity);
        return serviceProviderMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        serviceProviderRepository.deleteById(id);
    }
}
