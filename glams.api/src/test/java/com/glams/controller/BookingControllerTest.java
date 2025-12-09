package com.glams.controller;

import com.glams.dto.request.BookingRequestDTO;
import com.glams.dto.response.BookingResponseDTO;
import com.glams.enums.BookingStatus;
import com.glams.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookingControllerTest {

    @Mock
    private BookingService bookingService;

    @InjectMocks
    private BookingController bookingController;

    private BookingRequestDTO request;
    private BookingResponseDTO response;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        request = new BookingRequestDTO();
        request.setUserId(1L);
        request.setServiceId(2L);
        request.setBookingDate(LocalDate.now());
        request.setStartTime(LocalTime.of(10, 0));
        request.setEndTime(LocalTime.of(11, 0));
        request.setTotalAmount(BigDecimal.valueOf(100));
        request.setStatus(BookingStatus.CONFIRMED);

        response = new BookingResponseDTO();
        response.setId(1L);
        response.setUserId(1L);
        response.setServiceId(2L);
        response.setBookingDate(LocalDate.now());
        response.setStartTime(LocalTime.of(10, 0));
        response.setEndTime(LocalTime.of(11, 0));
        response.setTotalAmount(BigDecimal.valueOf(100));
        response.setStatus(BookingStatus.CONFIRMED);
    }

    @Test
    void testCreateBooking() {
        when(bookingService.create(request)).thenReturn(response);

        ResponseEntity<BookingResponseDTO> result = bookingController.create(request);

        assertEquals(response, result.getBody());
        verify(bookingService, times(1)).create(request);
    }

    @Test
    void testGetById() {
        when(bookingService.getById(1L)).thenReturn(response);

        ResponseEntity<BookingResponseDTO> result = bookingController.getById(1L);

        assertEquals(response, result.getBody());
        verify(bookingService, times(1)).getById(1L);
    }

    @Test
    void testGetAll() {
        when(bookingService.getAll()).thenReturn(List.of(response));

        ResponseEntity<List<BookingResponseDTO>> result = bookingController.getAll();

        assertEquals(1, result.getBody().size());
        verify(bookingService, times(1)).getAll();
    }

    @Test
    void testUpdate() {
        when(bookingService.update(1L, request)).thenReturn(response);

        ResponseEntity<BookingResponseDTO> result = bookingController.update(1L, request);

        assertEquals(response, result.getBody());
        verify(bookingService, times(1)).update(1L, request);
    }

    @Test
    void testDelete() {
        doNothing().when(bookingService).delete(1L);

        ResponseEntity<Void> result = bookingController.delete(1L);

        assertEquals(204, result.getStatusCodeValue());
        verify(bookingService, times(1)).delete(1L);
    }
}
