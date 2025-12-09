package com.glams.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceResponseDTO {

    private Long id;
    private Long providerId;
    private String category;
    private String name;
    private String description;
    private int price;
    private String capacity;
    private String location;
}
