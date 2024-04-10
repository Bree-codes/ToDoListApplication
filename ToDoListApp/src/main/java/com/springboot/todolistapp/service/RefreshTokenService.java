package com.springboot.todolistapp.service;

import com.springboot.todolistapp.entity.User;
import com.springboot.todolistapp.repository.RefreshTokenRepository;
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

    private final RefreshTokenRepository refreshTokenRepository;

    public String generateRefreshToken(User user){

        String refreshToken = UUID.randomUUID().toString();

        return UUID.randomUUID().toString();
    }

    private void saveRefreshToken(User user,String refreshToken){

        refreshTokenRepository.findById()
    }


}
