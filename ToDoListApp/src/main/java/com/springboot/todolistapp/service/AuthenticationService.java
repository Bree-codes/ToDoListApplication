package com.springboot.todolistapp.service;

import com.springboot.todolistapp.CustomeExceptions.UserAlreadyExistException;
import com.springboot.todolistapp.entity.User;
import com.springboot.todolistapp.repository.UserRepository;
import com.springboot.todolistapp.request.RegistrationRequest;
import com.springboot.todolistapp.response.AuthorizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository registrationRepository;
    private final JwtService jwtService;

    @Autowired
    public AuthenticationService(UserRepository registrationRepository, JwtService jwtService) {
        this.registrationRepository = registrationRepository;
        this.jwtService = jwtService;
    }

    public ResponseEntity<AuthorizationResponse> registerUser(RegistrationRequest registrationRequest) {

        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());

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

}


