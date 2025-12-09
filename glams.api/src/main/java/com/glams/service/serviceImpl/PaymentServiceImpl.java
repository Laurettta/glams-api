package com.glams.service.serviceImpl;

import com.glams.dto.request.PaymentRequestDTO;
import com.glams.dto.response.PaymentResponseDTO;
import com.glams.exception.ResourceNotFoundException;
import com.glams.mapper.PaymentMapper;
import com.glams.model.Booking;
import com.glams.model.Invoice;
import com.glams.model.Payment;
import com.glams.repository.BookingRepository;
import com.glams.repository.InvoiceRepository;
import com.glams.repository.PaymentRepository;
import com.glams.service.PaymentService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;
    private final InvoiceRepository invoiceRepository;
    private final PaymentMapper mapper;


    @Override
    public PaymentResponseDTO createPayment(PaymentRequestDTO dto){
        Booking booking = bookingRepository.findById(dto.getBookingId())
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        Invoice invoice = null;
        if(dto.getInvoiceId() != null){
            invoice = invoiceRepository.findById(dto.getInvoiceId())
                    .orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));
        }

        // check duplicate transaction
        paymentRepository.findByTransactionId(dto.getTransactionId())
                .ifPresent(p -> { throw new EntityExistsException("Transaction ID already exists"); });

        Payment payment = mapper.toEntity(dto);
        payment.setBooking(booking);
        payment.setInvoice(invoice);

        return mapper.toDto(paymentRepository.save(payment));
    }

    @Override
    public PaymentResponseDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));
        return mapper.toDto(payment);
    }

    @Override
    public List<PaymentResponseDTO> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public PaymentResponseDTO updatePayment(Long id, PaymentRequestDTO dto) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));
        mapper.updateFromDto(dto, payment);
        return mapper.toDto(paymentRepository.save(payment));
    }

    @Override
    public void deletePayment(Long id) {
        if(!paymentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Payment not found");
        }
        paymentRepository.deleteById(id);
    }
}
