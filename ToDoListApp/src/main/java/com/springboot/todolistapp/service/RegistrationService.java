package com.springboot.todolistapp.service;

import com.springboot.todolistapp.CustomeExceptions.UserAlreadyExistException;
import com.springboot.todolistapp.entity.User;
import com.springboot.todolistapp.repository.RegistrationRepository;
import com.springboot.todolistapp.request.RegistrationRequest;
import com.springboot.todolistapp.response.AuthorizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class RegistrationService implements UserDetailsService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
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
        //authorizationResponse.setJwt();
        authorizationResponse.setId(user.getId());
        authorizationResponse.setUsername(user.getUsername());
        authorizationResponse.setMessage("Registration Successful");
        authorizationResponse.setStatus(HttpStatus.OK);

        return new ResponseEntity<>(authorizationResponse,HttpStatus.OK);
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return  registrationRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username not found")
                );
    }
}


