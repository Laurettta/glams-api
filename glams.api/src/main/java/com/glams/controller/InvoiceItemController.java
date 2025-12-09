package com.glams.controller;

import com.glams.dto.request.InvoiceItemRequestDTO;
import com.glams.dto.response.InvoiceItemResponseDTO;
import com.glams.service.InvoiceItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice-items")
@RequiredArgsConstructor
public class InvoiceItemController {

    private final InvoiceItemService service;

    @PostMapping
    public ResponseEntity<InvoiceItemResponseDTO> create(@RequestBody InvoiceItemRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceItemResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<InvoiceItemResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceItemResponseDTO> update(@PathVariable Long id,
                                                         @RequestBody InvoiceItemRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
