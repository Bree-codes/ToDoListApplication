package com.springboot.todolistapp.configuration;

import com.springboot.todolistapp.CustomExceptions.InvalidToken;
import com.springboot.todolistapp.entity.Token;
import com.springboot.todolistapp.repository.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomLogoutHandler implements LogoutHandler {

    private final TokenRepository tokenRepository;
    @Override
    public void logout(
            HttpServletRequest request,

            HttpServletResponse response,

            Authentication authentication) {

        /*this handle will handle the logout process of the application*/

        //getting the Authorization header from the request.

        String authHeader = request.getHeader("Authorization");

        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            return;
        }

        /*Extracting the jwt from the header*/
        String jwt = authHeader.substring(7);

        //getting the token information from the database
        Token token = tokenRepository.findByToken(jwt).orElseThrow(()-> new InvalidToken("Token Not Recognized."));

        token.setIsLoggedOut(true);

        //update the token logged out status.
        tokenRepository.save(token);
    }

}
