package com.glams.service.serviceImpl;

import com.glams.dto.request.ServiceClientLinkRequestDTO;
import com.glams.dto.response.ServiceClientLinkResponseDTO;
import com.glams.mapper.ServiceClientLinkMapper;
import com.glams.model.Client;
import com.glams.model.ServiceClientLink;
import com.glams.model.ServiceProvider;
import com.glams.repository.ClientRepository;
import com.glams.repository.ServiceClientLinkRepository;
import com.glams.repository.ServiceProviderRepository;
import com.glams.service.ServiceClientLinkService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceClientLinkImpl implements ServiceClientLinkService {

    private final ServiceClientLinkRepository repository;
    private final ClientRepository clientRepository; // ✅ Use ClientRepository instead of UserRepository
    private final ServiceProviderRepository serviceProviderRepository;
    private final ServiceClientLinkMapper mapper;

    @Override
    public ServiceClientLinkResponseDTO create(ServiceClientLinkRequestDTO dto) {

        // Check if link already exists
        if (repository.existsByClientIdAndServiceProviderId(dto.getClientId(), dto.getServiceProviderId())) {
            throw new IllegalArgumentException("Link already exists");
        }

        // Fetch client
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));

        // Fetch service provider
        ServiceProvider sp = serviceProviderRepository.findById(dto.getServiceProviderId())
                .orElseThrow(() -> new EntityNotFoundException("Service Provider not found"));

        // Build entity
        ServiceClientLink entity = ServiceClientLink.builder()
                .client(client)  // ✅ now type matches
                .serviceProvider(sp)
                .build();

        // Save to DB
        ServiceClientLink saved = repository.save(entity);

        return mapper.toDTO(saved);
    }

    @Override
    public ServiceClientLinkResponseDTO getServiceClientLinkById(Long id) {
        ServiceClientLink entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ServiceClientLink not found"));
        return mapper.toDTO(entity);
    }

    @Override
    public List<ServiceClientLinkResponseDTO> getAllServiceClientLink() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("ServiceClientLink not found");
        }
        repository.deleteById(id);
    }
}
