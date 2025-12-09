package com.glams.controller;

import com.glams.dto.request.ServiceRequestDTO;
import com.glams.dto.response.ServiceResponseDTO;
import com.glams.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceService service;

    @PostMapping
    public ResponseEntity<ServiceResponseDTO> create(@RequestBody ServiceRequestDTO dto) {
        return ResponseEntity.ok(service.createService(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getServiceById(id));
    }

    @GetMapping
    public ResponseEntity<List<ServiceResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAllService());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceResponseDTO> update(@PathVariable Long id, @RequestBody ServiceRequestDTO dto) {
        return ResponseEntity.ok(service.updateService(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
