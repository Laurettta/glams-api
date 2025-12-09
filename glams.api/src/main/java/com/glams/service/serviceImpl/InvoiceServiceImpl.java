package com.glams.service.serviceImpl;

import com.glams.dto.request.InvoiceRequestDTO;
import com.glams.dto.response.InvoiceResponseDTO;
import com.glams.exception.ResourceNotFoundException;
import com.glams.mapper.InvoiceMapper;
import com.glams.model.Booking;
import com.glams.model.Invoice;
import com.glams.repository.BookingRepository;
import com.glams.repository.InvoiceRepository;
import com.glams.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final BookingRepository bookingRepository;
    private final InvoiceMapper mapper;

    @Override
    public InvoiceResponseDTO create(InvoiceRequestDTO dto) {
        Booking booking = bookingRepository.findById(dto.getBookingId())
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        Invoice invoice = mapper.toEntity(dto);
        invoice.setBooking(booking);

        Invoice saved = invoiceRepository.save(invoice);
        return mapper.toDto(saved);
    }

    @Override
    public InvoiceResponseDTO getById(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));
        return mapper.toDto(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> getAll() {
        return invoiceRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public InvoiceResponseDTO update(Long id, InvoiceRequestDTO dto) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));

        mapper.updateFromDto(dto, invoice);
        Booking booking = bookingRepository.findById(dto.getBookingId())
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
        invoice.setBooking(booking);

        return mapper.toDto(invoiceRepository.save(invoice));
    }

    @Override
    public void delete(Long id) {
        if (!invoiceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Invoice not found");
        }
        invoiceRepository.deleteById(id);
    }
}
