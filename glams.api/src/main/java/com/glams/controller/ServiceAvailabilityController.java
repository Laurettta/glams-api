package com.glams.controller;

import com.glams.dto.request.ServiceAvailabilityRequestDTO;
import com.glams.dto.response.ServiceAvailabilityResponseDTO;
import com.glams.service.ServiceAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-availability")
@RequiredArgsConstructor
public class ServiceAvailabilityController {

    private final ServiceAvailabilityService service;

    @PostMapping
    public ResponseEntity<ServiceAvailabilityResponseDTO> create(@RequestBody ServiceAvailabilityRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceAvailabilityResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getServiceAvailabilityById(id));
    }

    @GetMapping
    public ResponseEntity<List<ServiceAvailabilityResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAllServiceAvailability());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceAvailabilityResponseDTO> update(@PathVariable Long id, @RequestBody ServiceAvailabilityRequestDTO dto) {
        return ResponseEntity.ok(service.updateServiceAvailability(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
