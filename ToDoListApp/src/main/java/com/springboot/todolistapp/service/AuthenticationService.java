package com.springboot.todolistapp.service;

import com.springboot.todolistapp.CustomeExceptions.UserAlreadyExistException;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService{

    private final UserRepository registrationRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;

    @Autowired
    public AuthenticationService(UserRepository registrationRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenRepository tokenRepository) {
        this.registrationRepository = registrationRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenRepository = tokenRepository;
    }

    public ResponseEntity<AuthorizationResponse> registerUser(RegistrationRequest registrationRequest) {

        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setRole(registrationRequest.getRole());

        /*before saving lets confirm the user does not exist.*/
        registrationRepository.findByEmail(registrationRequest.getEmail()).ifPresent(
                (user1) -> {
                    throw new UserAlreadyExistException("The Email Your Entered Already Exist");
                }
        );
        registrationRepository.save(user);

        AuthorizationResponse authorizationResponse = new AuthorizationResponse();
        authorizationResponse.setJwt(jwtService.generateToken(user));
        authorizationResponse.setId(user.getId());
        authorizationResponse.setUsername(user.getUsername());
        authorizationResponse.setMessage("Registration Successful");
        authorizationResponse.setStatus(HttpStatus.OK);

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

    public AuthorizationResponse authenticate(LoginRequest loginRequest) {

        return null;
    }
}


