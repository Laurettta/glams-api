package com.glams.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceProviderResponseDTO {

    private Long id;
    private Long userId;
    private String businessName;
    private String businessAddress;
    private String description;
}
