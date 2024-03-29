package com.springboot.todolistapp.service;

import com.springboot.todolistapp.CustomExceptions.UserAlreadyExistException;
import com.springboot.todolistapp.entity.Token;
import com.springboot.todolistapp.entity.User;
import com.springboot.todolistapp.repository.TokenRepository;
import com.springboot.todolistapp.repository.UserRepository;
import com.springboot.todolistapp.request.LoginRequest;
import com.springboot.todolistapp.request.RegistrationRequest;
import com.springboot.todolistapp.response.AuthorizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public ResponseEntity<AuthorizationResponse> registerUser(RegistrationRequest registrationRequest) {

        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));


        /*Check if the username is already in user by another user*/
        userRepository.findByUsername(registrationRequest.getUsername()).ifPresent(
                (user1) ->{
                    throw  new UserAlreadyExistException("Username you entered is Already in use.");
                }
        );


        /*before saving, let's confirm the user does not exist.*/
        userRepository.findByEmail(registrationRequest.getEmail()).ifPresent(
                (user1) -> {
                    throw new UserAlreadyExistException("The Email Your Entered Already Exist");
                }
        );

        userRepository.save(user);

        AuthorizationResponse authorizationResponse = new AuthorizationResponse();
        authorizationResponse.setJwt(jwtService.generateToken(user));
        authorizationResponse.setId(user.getId());
        authorizationResponse.setUsername(user.getUsername());
        authorizationResponse.setMessage("Registration Successful");
        authorizationResponse.setStatus(HttpStatus.OK);

        saveToken(user, authorizationResponse.getJwt());

        return new ResponseEntity<>(authorizationResponse,HttpStatus.OK);
    }

    private void revokeAllTokenByUser(User user) {
        List<Token> validTokenListByUser = tokenRepository.findAllTokensByUser(Math.toIntExact(user.getId()));
        if(!validTokenListByUser.isEmpty()){
            validTokenListByUser.forEach(t->{
                t.setIsLoggedOut(true);
            });
        }

        tokenRepository.saveAll(validTokenListByUser);
    }

    public AuthorizationResponse authenticate( LoginRequest loginRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(

                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        User user =  userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();

        AuthorizationResponse authorizationResponse = new AuthorizationResponse();
        authorizationResponse.setUsername(user.getUsername());
        authorizationResponse.setJwt(jwtService.generateToken(user));
        authorizationResponse.setMessage("Login successful");
        authorizationResponse.setStatus(HttpStatus.OK);
        authorizationResponse.setId(user.getId());


        revokeAllTokenByUser(user);
        saveToken(user, authorizationResponse.getJwt());



        return authorizationResponse;
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


