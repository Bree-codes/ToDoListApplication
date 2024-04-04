package com.bree.primarykeygeneration.springjpa.addressbook.entity;


import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="addresses")
public class Addresses {

    public static Addresses saved;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "country",nullable = false)
    private String country;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "state",nullable = false)
    private String state;

    @Column(name = "zip_code",nullable = false)
    private String zip_code;


}
