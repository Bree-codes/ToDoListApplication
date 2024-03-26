package com.springboot.todolistapp.service;

import com.springboot.todolistapp.CustomeExceptions.UserAlreadyExistException;
import com.springboot.todolistapp.entity.RegistrationEntity;
import com.springboot.todolistapp.repository.RegistrationRepository;
import com.springboot.todolistapp.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public void registerUser(RegistrationRequest registrationRequest) {

        RegistrationEntity registration = new RegistrationEntity();
        registration.setUsername(registrationRequest.getUsername());
        registration.setEmail(registrationRequest.getEmail());
        registration.setPassword(registrationRequest.getPassword());

        /*before saving lets confirm the user does not exist.*/

        registrationRepository.findByEmail(registrationRequest.getEmail()).ifPresent(
                (registrationEntity) -> {
                    throw new UserAlreadyExistException("The Email Your Entered Already Exist");
                }
        );
        registrationRepository.save(registration);
    }
}
