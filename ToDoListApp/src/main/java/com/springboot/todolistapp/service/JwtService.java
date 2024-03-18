package com.springboot.todolistapp.service;

import com.springboot.todolistapp.entity.User;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtService {

    @Value("${service.secretKey}")
    private String secretKey;




    public String generateToken(User user){

        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(new Date(System.currentTimeMillis() + 1000*60*60*24))
                .issuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSigninKey())
                .compact();
    }

    private Key getSigninKey() {
return null;
    }
}
