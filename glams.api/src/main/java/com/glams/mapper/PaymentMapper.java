package com.glams.mapper;

import com.glams.dto.request.PaymentRequestDTO;
import com.glams.dto.response.PaymentResponseDTO;
import com.glams.model.Payment;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "booking.id", source = "bookingId")
    @Mapping(target = "invoice.id", source = "invoiceId")
    Payment toEntity(PaymentRequestDTO dto);

    @Mapping(target = "bookingId", source = "booking.id")
    @Mapping(target = "invoiceId", source = "invoice.id")
    PaymentResponseDTO toDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(PaymentRequestDTO dto, @MappingTarget Payment entity);
}
