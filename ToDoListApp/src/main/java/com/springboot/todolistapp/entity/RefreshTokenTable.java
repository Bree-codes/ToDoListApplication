package com.springboot.todolistapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Entity
@Component
public class RefreshTokenTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refreshTokenId;

    private String refreshToken;

    private Date expirationDate;

    @OneToOne()
    @JoinColumn(name = 'user_fk')
    private User user;
}
