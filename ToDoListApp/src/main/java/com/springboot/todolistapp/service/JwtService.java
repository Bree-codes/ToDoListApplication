package com.springboot.todolistapp.service;

import com.springboot.todolistapp.repository.TokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtService {

    private final TokenRepository tokenRepository;

    private final RefreshTokenService refreshTokenService;


    @Value("${service.secretKey}")
    private String secretKey;
    public String generateToken(UserDetails user){

        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(new Date(System.currentTimeMillis() + 1000*60*60*24))
                .issuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSigningKey())
                .compact();
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAllClaims(String jwt){
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                 .parseSignedClaims(jwt)
                .getPayload();
    }

    public String extractUserName(String jwt){
        return extractClaim(Claims::getSubject, jwt);
    }

    private Date extractExpirationDate(String jwt){
        return extractClaim(Claims::getExpiration, jwt);
    }

    private <T> T extractClaim(Function<Claims, T> claimExtractor, String jwt){
        Claims claims = extractAllClaims(jwt);
        return claimExtractor.apply(claims);
    }

    private Boolean isExpired(String jwt){
        return (extractExpirationDate(jwt).compareTo(new Date(System.currentTimeMillis())) < 0);
    }

    public Boolean isValid(String jwt, UserDetails userDetails, HttpServletResponse response, HttpServletRequest request){

        String username = (extractUserName(jwt));

        boolean isTokenValid = tokenRepository.findByToken(jwt).
                map(t -> !t.getIsLoggedOut()).orElse(false);

        if(!(username.equals(userDetails.getUsername())  && isTokenValid)){
            return false;
        }

        if(isExpired(jwt)){
            String cookie = request.getHeader("cookie");

            if(cookie == null || !cookie.startsWith("auth_token=")){
                return false;
            }

            String uuid = cookie.substring(11);

            if(refreshTokenService.isValid(uuid)){

            }
            return false;
        }
        return true;
    }

}


