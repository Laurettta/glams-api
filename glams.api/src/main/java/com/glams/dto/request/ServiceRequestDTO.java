package com.glams.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceRequestDTO {

    private Long providerId;
    private String category;
    private String name;
    private String description;
    private int price;
    private String capacity;
    private String location;
}
