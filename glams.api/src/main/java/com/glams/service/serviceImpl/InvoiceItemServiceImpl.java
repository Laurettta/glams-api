package com.glams.service.serviceImpl;

import com.glams.dto.request.InvoiceItemRequestDTO;
import com.glams.dto.response.InvoiceItemResponseDTO;
import com.glams.exception.ResourceNotFoundException;
import com.glams.mapper.InvoiceItemMapper;
import com.glams.model.Invoice;
import com.glams.model.InvoiceItem;
import com.glams.repository.InvoiceItemRepository;
import com.glams.repository.InvoiceRepository;
import com.glams.service.InvoiceItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceItemServiceImpl implements InvoiceItemService {

    private final InvoiceItemRepository repository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceItemMapper mapper;

    @Override
    public InvoiceItemResponseDTO create(InvoiceItemRequestDTO dto) {
        Invoice invoice = invoiceRepository.findById(dto.getInvoiceId())
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));

        InvoiceItem item = mapper.toEntity(dto);
        item.setInvoice(invoice);

        return mapper.toDto(repository.save(item));
    }

    @Override
    public InvoiceItemResponseDTO getById(Long id) {
        InvoiceItem item = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice item not found"));
        return mapper.toDto(item);
    }

    @Override
    public List<InvoiceItemResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public InvoiceItemResponseDTO update(Long id, InvoiceItemRequestDTO dto) {
        InvoiceItem item = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice item not found"));

        mapper.updateFromDto(dto, item);
        item.setTotalPrice(dto.getPrice() * dto.getQuantity());

        return mapper.toDto(repository.save(item));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Invoice item not found");
        }
        repository.deleteById(id);
    }
}
