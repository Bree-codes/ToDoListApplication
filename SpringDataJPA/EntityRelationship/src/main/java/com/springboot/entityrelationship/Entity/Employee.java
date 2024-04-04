package com.springboot.entityrelationship.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    private String name;
    private int age;

    @OneToOne(mappedBy = "employee")
    private Address address;

}

