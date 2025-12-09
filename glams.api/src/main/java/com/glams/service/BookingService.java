package com.glams.service;

import com.glams.dto.request.BookingRequestDTO;
import com.glams.dto.response.BookingResponseDTO;

import java.util.List;

public interface BookingService {

    BookingResponseDTO create(BookingRequestDTO dto);

    BookingResponseDTO getById(Long id);

    List<BookingResponseDTO> getAll();

    BookingResponseDTO update(Long id, BookingRequestDTO dto);

    void delete(Long id);
}
