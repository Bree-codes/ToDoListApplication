package com.springboot.todolistapp.service;

import com.springboot.todolistapp.CustomExceptions.UserAlreadyExistException;
import com.springboot.todolistapp.entity.Token;
import com.springboot.todolistapp.entity.User;
import com.springboot.todolistapp.repository.TokenRepository;
import com.springboot.todolistapp.repository.UserRepository;
import com.springboot.todolistapp.request.LoginRequest;
import com.springboot.todolistapp.request.RegistrationRequest;
import com.springboot.todolistapp.response.AuthorizationResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService{

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;

    @Autowired
    public AuthenticationService(UserRepository userRepository, JwtService jwtService,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager,
                                 TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenRepository = tokenRepository;
    }

    public ResponseEntity<AuthorizationResponse> registerUser(
            RegistrationRequest registrationRequest, HttpServletResponse response) {

        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));


        /*Check if the username is already in user by another user*/
        userRepository.findByUsername(registrationRequest.getUsername()).ifPresent(
                (user1) ->{
                    throw  new UserAlreadyExistException("The Username you entered is already in use.");
                }
        );


        /*before saving, let's confirm the user does not exist.*/
        userRepository.findByEmail(registrationRequest.getEmail()).ifPresent(
                (user1) -> {
                    throw new UserAlreadyExistException("The Email your entered is already in use");
                }
        );


        //getting the refresh token cookie
        Cookie cookie = getCookie(user);

        //setting the cookie to the response
        response.addCookie(cookie);

        //adding the new user to the database
        userRepository.save(user);

        //preparing the user response.
        AuthorizationResponse authorizationResponse = new AuthorizationResponse();
        authorizationResponse.setJwt(jwtService.generateToken(user));
        authorizationResponse.setId(user.getId());
        authorizationResponse.setUsername(user.getUsername());
        authorizationResponse.setMessage("Registration Successful");
        authorizationResponse.setStatus(HttpStatus.OK);

        //saving the access token to the database.
        saveToken(user, authorizationResponse.getJwt());

        return new ResponseEntity<>(authorizationResponse,HttpStatus.OK);
    }

    private void revokeAllTokenByUser(User user) {
        List<Token> validTokenListByUser = tokenRepository.findAllTokensByUser(Math.toIntExact(user.getId()));
        if(!validTokenListByUser.isEmpty()){
            validTokenListByUser.forEach(t-> t.setIsLoggedOut(true));
        }

        tokenRepository.saveAll(validTokenListByUser);
    }

    public AuthorizationResponse authenticate(LoginRequest loginRequest, HttpServletResponse response) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword())
        );

        /*getting the user*/
        User user =  userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();

        //adding the http only cookie
        Cookie cookie = getCookie(user);
        response.addCookie(cookie);

        /*user response*/
        AuthorizationResponse authorizationResponse = new AuthorizationResponse();
        authorizationResponse.setJwt(jwtService.generateToken(user));
        authorizationResponse.setUsername(user.getUsername());
        authorizationResponse.setMessage("Login successful");
        authorizationResponse.setStatus(HttpStatus.OK);
        authorizationResponse.setId(user.getId());


        /*This will ensure only one access token is available for a given user.*/
        revokeAllTokenByUser(user);
        saveToken(user, authorizationResponse.getJwt());

        return authorizationResponse;
    }

    private Cookie getCookie(User user) {


        Cookie cookie = new Cookie("auth_token", "3");

        cookie.setHttpOnly(true);
        cookie.setMaxAge(1000*60*60*24*14);
        cookie.setSecure(false);
        cookie.setPath("/todo/app");


        return cookie;
    }

    private void saveToken(User user, String jwt) {
        Token token = new Token();

        token.setToken(jwt);
        token.setUser(user);
        token.setIsLoggedOut(false);

        tokenRepository.save(token);
    }

    public void logout(Long id) {

        User user = userRepository.findById(id).orElseThrow();
        revokeAllTokenByUser(user);
    }
}


