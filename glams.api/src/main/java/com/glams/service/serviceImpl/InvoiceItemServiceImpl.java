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
        Invoice invoice = getInvoice(dto.getInvoiceId());

        validateDto(dto);

        InvoiceItem item = mapper.toEntity(dto);
        item.setInvoice(invoice);
        item.setTotalPrice(dto.getPrice() * dto.getQuantity());

        return mapper.toDto(repository.save(item));
    }

    @Override
    public InvoiceItemResponseDTO getById(Long id) {
        InvoiceItem item = findInvoiceItem(id);
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
        InvoiceItem item = findInvoiceItem(id);

        validateDto(dto);

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

    // ----------------- Private helper methods -----------------

    private InvoiceItem findInvoiceItem(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice item not found"));
    }

    private Invoice getInvoice(Long invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));
    }

    private void validateDto(InvoiceItemRequestDTO dto) {
        if (dto.getItemName() == null || dto.getItemName().isBlank()) {
            throw new IllegalArgumentException("Item name must not be null or empty");
        }
        if (dto.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (dto.getPrice() < 0) {
            throw new IllegalArgumentException("Price must not be negative");
        }
    }
}
