package com.glams.service;

import com.glams.dto.request.InvoiceItemRequestDTO;
import com.glams.dto.response.InvoiceItemResponseDTO;

import java.util.List;

public interface InvoiceItemService {

    InvoiceItemResponseDTO create(InvoiceItemRequestDTO dto);

    InvoiceItemResponseDTO getById(Long id);

    List<InvoiceItemResponseDTO> getAll();

    InvoiceItemResponseDTO update(Long id, InvoiceItemRequestDTO dto);

    void delete(Long id);
}
