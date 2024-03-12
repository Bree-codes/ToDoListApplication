package com.springboot.todolistapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "UserRegistrationDetails")
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String username;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;


}
