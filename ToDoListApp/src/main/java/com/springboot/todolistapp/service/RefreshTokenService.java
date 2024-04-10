package com.springboot.todolistapp.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@Data
@RequiredArgsConstructor
public class RefreshTokenService {

    public String generateRefreshToken(){
        return UUID.randomUUID().toString();
    }


}
