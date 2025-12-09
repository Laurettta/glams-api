package com.glams.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceClientLinkResponseDTO {

    private Long id;
    private Long clientId;
    private Long serviceProviderId;
}
