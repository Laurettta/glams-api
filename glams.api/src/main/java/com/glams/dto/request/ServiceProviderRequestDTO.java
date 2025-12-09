package com.glams.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceProviderRequestDTO {

    private Long userId;
    private String businessName;
    private String businessAddress;
    private String description;
}
