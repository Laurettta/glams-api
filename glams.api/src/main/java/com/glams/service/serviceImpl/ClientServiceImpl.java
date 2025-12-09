package com.glams.service.serviceImpl;

import com.glams.dto.request.ClientRequestDTO;
import com.glams.dto.response.ClientResponseDTO;
import com.glams.exception.ResourceNotFoundException;
import com.glams.mapper.ClientMapper;
import com.glams.model.Client;
import com.glams.model.User;
import com.glams.repository.ClientRepository;
import com.glams.repository.UserRepository;
import com.glams.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final ClientMapper mapper;

    @Override
    public ClientResponseDTO create(ClientRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Client client = mapper.toEntity(dto);
        client.setUser(user);

        Client saved = clientRepository.save(client);
        return mapper.toDto(saved);
    }

    @Override
    public ClientResponseDTO getById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        return mapper.toDto(client);
    }

    @Override
    public List<ClientResponseDTO> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public ClientResponseDTO update(Long id, ClientRequestDTO dto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        mapper.updateFromDto(dto, client);
        client.setUser(user);

        return mapper.toDto(clientRepository.save(client));
    }

    @Override
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Client not found");
        }
        clientRepository.deleteById(id);
    }


}
