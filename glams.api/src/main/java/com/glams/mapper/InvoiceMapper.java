package com.glams.mapper;

import com.glams.dto.request.InvoiceRequestDTO;
import com.glams.dto.response.InvoiceResponseDTO;
import com.glams.model.Invoice;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    @Mapping(target = "booking.id", source = "bookingId")
    Invoice toEntity(InvoiceRequestDTO dto);

    @Mapping(target = "bookingId", source = "booking.id")
    InvoiceResponseDTO toDto(Invoice invoice);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(InvoiceRequestDTO dto, @MappingTarget Invoice invoice);
}
