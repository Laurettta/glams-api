package com.glams.service;

import com.glams.dto.request.ClientRequestDTO;
import com.glams.dto.response.ClientResponseDTO;

import java.util.List;

public interface ClientService {

    ClientResponseDTO create(ClientRequestDTO dto);

    ClientResponseDTO getById(Long id);

    List<ClientResponseDTO> getAll();

    ClientResponseDTO update(Long id, ClientRequestDTO dto);

    void delete(Long id);
}
