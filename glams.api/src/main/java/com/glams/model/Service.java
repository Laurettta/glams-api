package com.glams.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "services")
@Entity
@Builder
@EqualsAndHashCode(callSuper = false)
public class Service extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String name;
    private String description;
    private int price;
    private String capacity;
    private String location;

//    Many Services -> one provider
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private ServiceProvider provider;

//    One Service -> Many Bookings
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Booking> bookings;

//    One service -> Many Availability slots
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<ServiceAvailability> availabilities;

//    one service -> many reviews
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Review> reviews;
}
