package com.springboot.todolistapp.repository;

import com.springboot.todolistapp.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity,Long> {

    Optional<RegistrationEntity> findByEmail(String email);

}
