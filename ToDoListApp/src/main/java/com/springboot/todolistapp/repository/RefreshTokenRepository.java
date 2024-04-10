package com.springboot.todolistapp.repository;

import com.springboot.todolistapp.entity.RefreshTokenTable;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshTokenTable, Long> {

}
