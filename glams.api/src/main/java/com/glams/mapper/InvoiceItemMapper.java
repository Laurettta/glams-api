package com.glams.mapper;

import com.glams.dto.request.InvoiceItemRequestDTO;
import com.glams.dto.response.InvoiceItemResponseDTO;
import com.glams.model.InvoiceItem;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface InvoiceItemMapper {

    @Mapping(target = "invoice.id", source = "invoiceId")
    @Mapping(target = "itemName", source = "itemName")
    @Mapping(target = "totalPrice", expression = "java(dto.getPrice() * dto.getQuantity())")
    InvoiceItem toEntity(InvoiceItemRequestDTO dto);

    @Mapping(target = "invoiceId", source = "invoice.id")
    InvoiceItemResponseDTO toDto(InvoiceItem entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(InvoiceItemRequestDTO dto, @MappingTarget InvoiceItem entity);
}
