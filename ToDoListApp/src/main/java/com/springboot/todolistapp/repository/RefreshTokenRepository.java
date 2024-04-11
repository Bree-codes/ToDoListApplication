package com.springboot.todolistapp.repository;

import com.springboot.todolistapp.entity.RefreshTokenTable;
import com.springboot.todolistapp.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshTokenTable, Long> {

    Optional<List<RefreshTokenTable>> findByUser(User user);

    Optional<RefreshTokenTable> findByRefreshToken(String refreshToken);
}
