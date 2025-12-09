package com.glams.service.serviceImpl;

import com.glams.dto.request.BookingRequestDTO;
import com.glams.dto.response.BookingResponseDTO;
import com.glams.exception.ResourceNotFoundException;
import com.glams.mapper.BookingMapper;
import com.glams.model.Booking;
import com.glams.model.User;
import com.glams.repository.BookingRepository;
import com.glams.repository.ServiceRepository;
import com.glams.repository.UserRepository;
import com.glams.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;
    private final BookingMapper mapper;

    @Override
    public BookingResponseDTO create(BookingRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        com.glams.model.Service service = serviceRepository.findById(dto.getServiceId())
                .orElseThrow(() -> new ResourceNotFoundException("Service not found"));

        Booking booking = mapper.toEntity(dto);
        booking.setUser(user);
        booking.setService(service);

        return mapper.toDto(bookingRepository.save(booking));
    }

    @Override
    public BookingResponseDTO getById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
        return mapper.toDto(booking);
    }

    @Override
    public List<BookingResponseDTO> getAll() {
        return bookingRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public BookingResponseDTO update(Long id, BookingRequestDTO dto) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        com.glams.model.Service service = serviceRepository.findById(dto.getServiceId())
                .orElseThrow(() -> new ResourceNotFoundException("Service not found"));

        mapper.updateFromDto(dto, booking);
        booking.setUser(user);
        booking.setService(service);

        return mapper.toDto(bookingRepository.save(booking));
    }

    @Override
    public void delete(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Booking not found");
        }
        bookingRepository.deleteById(id);
    }
}
