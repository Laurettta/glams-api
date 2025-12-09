package com.glams.mapper;

import com.glams.dto.request.BookingRequestDTO;
import com.glams.dto.response.BookingResponseDTO;
import com.glams.model.Booking;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "service.id", source = "serviceId")
    Booking toEntity(BookingRequestDTO dto);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "serviceId", source = "service.id")
    BookingResponseDTO toDto(Booking booking);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(BookingRequestDTO dto, @MappingTarget Booking booking);
}
