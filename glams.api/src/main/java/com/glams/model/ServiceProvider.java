package com.glams.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "service_providers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class ServiceProvider extends CreatedOnlyEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String businessName;
    private String businessAddress;
    private String description;

//    One Provider -> Many Services
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Service> services;


}
