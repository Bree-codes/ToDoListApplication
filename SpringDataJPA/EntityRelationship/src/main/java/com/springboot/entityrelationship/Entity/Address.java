package com.springboot.entityrelationship.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    private String city;

    private String addressType;

    @OneToOne
    @JoinColumn(name = "fk_address_id")
    private Employee employee;
}
