package com.springboot.todolistapp.service;

import com.springboot.todolistapp.entity.RefreshTokenTable;
import com.springboot.todolistapp.entity.User;
import com.springboot.todolistapp.repository.RefreshTokenRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
@Data
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public String generateRefreshToken(User user){

        String refreshToken = UUID.randomUUID().toString();

        //performing the database operation for refresh token generation.
        saveRefreshToken(user, refreshToken);

        return refreshToken;
    }

    private void saveRefreshToken(User user,String refreshToken){

        //get the user refresh tokens if present and delete them before setting a new one
        refreshTokenRepository.findByUser(user).ifPresent(refreshTokenRepository::deleteAll);

        //saving the refresh token

        RefreshTokenTable refreshTokenTable = new RefreshTokenTable();
        refreshTokenTable.setRefreshToken(refreshToken);
        refreshTokenTable.setUser(user);
        refreshTokenTable.setExpirationDate((new Date(System.currentTimeMillis()+ 1000*60*60*24*14)) );

        //saving to database.
        refreshTokenRepository.save(refreshTokenTable);
    }

}
