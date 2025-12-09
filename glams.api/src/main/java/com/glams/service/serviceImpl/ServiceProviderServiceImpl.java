package com.glams.service.serviceImpl;

import com.glams.dto.request.ServiceProviderRequestDTO;
import com.glams.dto.response.ServiceProviderResponseDTO;
import com.glams.mapper.ServiceProviderMapper;
import com.glams.model.ServiceProvider;
import com.glams.repository.ServiceProviderRepository;
import com.glams.service.ServiceProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceProviderServiceImpl implements ServiceProviderService {

    private final ServiceProviderRepository serviceProviderRepository;
    private final ServiceProviderMapper serviceProviderMapper;


    @Override
    public ServiceProviderResponseDTO create(ServiceProviderRequestDTO dto){
        ServiceProvider entity = serviceProviderMapper.toEntity(dto);
        ServiceProvider saved = serviceProviderRepository.save(entity);
        return serviceProviderMapper.toDTO(saved);
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
