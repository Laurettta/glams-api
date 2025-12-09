package com.glams.repository;

import com.glams.model.ServiceClientLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceClientLinkRepository extends JpaRepository<ServiceClientLink, Long> {

    boolean existsByClientIdAndServiceProviderId(Long clientId, Long serviceProviderId);
}
