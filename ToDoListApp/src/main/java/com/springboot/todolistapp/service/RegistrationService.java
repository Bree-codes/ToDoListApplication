package com.springboot.todolistapp.service;

import com.springboot.todolistapp.entity.RegistrationEntity;
import com.springboot.todolistapp.repository.RegistrationRepository;
import com.springboot.todolistapp.request.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public RegistrationEntity registerUser(RegistrationRequest registrationRequest) {

        RegistrationEntity registration = new RegistrationEntity();
        registration.setUsername(registrationRequest.getUsername());
        registration.setEmail(registrationRequest.getEmail());
        registration.setPassword(registrationRequest.getPassword());

        return registrationRepository.save(registration);

    }
}

