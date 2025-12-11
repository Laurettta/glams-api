package com.glams.controller;

import com.glams.dto.request.InvoiceRequestDTO;
import com.glams.dto.response.InvoiceResponseDTO;
import com.glams.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
@Tag(name = "Invoices", description = "Operations related to invoices")
public class InvoiceController {

    private final InvoiceService service;

    @Operation(summary = "Create a new invoice")
    @PostMapping
    public ResponseEntity<InvoiceResponseDTO> create(@RequestBody InvoiceRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @Operation(summary = "Get invoice by ID")
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<InvoiceResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceResponseDTO> update(@PathVariable Long id,
                                                     @RequestBody InvoiceRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
