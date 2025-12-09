package com.glams.controller;

import com.glams.dto.request.ServiceProviderRequestDTO;
import com.glams.dto.response.ServiceProviderResponseDTO;
import com.glams.service.ServiceProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pro")
@RequiredArgsConstructor
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;

    @PostMapping
    public ResponseEntity<ServiceProviderResponseDTO> create(@RequestBody ServiceProviderRequestDTO requestDTO){
        return ResponseEntity.ok(serviceProviderService.create(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProviderResponseDTO> getServiceProviderById(@PathVariable Long id){
        return ResponseEntity.ok(serviceProviderService.getServiceProviderById(id));
    }

    @GetMapping
    public ResponseEntity<List<ServiceProviderResponseDTO>> getAllServiceProvider(){
        return ResponseEntity.ok(serviceProviderService.getAllServiceProvider());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceProviderResponseDTO> updateServiceProvider(@PathVariable Long id, @RequestBody ServiceProviderRequestDTO requestDTO){
        return ResponseEntity.ok(serviceProviderService.updateServiceProvider(id,requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        serviceProviderService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
