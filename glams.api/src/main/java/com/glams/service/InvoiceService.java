package com.glams.service;

import com.glams.dto.request.InvoiceRequestDTO;
import com.glams.dto.response.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {

    InvoiceResponseDTO create(InvoiceRequestDTO dto);

    InvoiceResponseDTO getById(Long id);

    List<InvoiceResponseDTO> getAll();

    InvoiceResponseDTO update(Long id, InvoiceRequestDTO dto);

    void delete(Long id);
}
