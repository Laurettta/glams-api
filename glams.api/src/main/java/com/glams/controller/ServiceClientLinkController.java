package com.glams.controller;


import com.glams.dto.request.ServiceClientLinkRequestDTO;
import com.glams.dto.response.ServiceClientLinkResponseDTO;
import com.glams.service.ServiceClientLinkService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-client-link")
@Data
public class ServiceClientLinkController {

    private final ServiceClientLinkService serviceClientLinkService;

    @PostMapping
    public ResponseEntity<ServiceClientLinkResponseDTO> create (@RequestBody ServiceClientLinkRequestDTO requestDTO){
        return ResponseEntity.ok(serviceClientLinkService.create(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceClientLinkResponseDTO> getServiceClientLinkById(@PathVariable Long id){
        return ResponseEntity.ok(serviceClientLinkService.getServiceClientLinkById(id));
    }

    @GetMapping
    public ResponseEntity<List<ServiceClientLinkResponseDTO>> getAllServiceClientLink(){
        return  ResponseEntity.ok(serviceClientLinkService.getAllServiceClientLink());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        serviceClientLinkService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
