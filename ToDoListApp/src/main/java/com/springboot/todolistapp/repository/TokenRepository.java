package com.springboot.todolistapp.repository;

import com.springboot.todolistapp.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TokenRepository extends JpaRepository<Token,Integer> {


    @Query("""
     select t from Token t inner join User u on t.user.id = u.id
     where t.user.id = :userId and t.isLoggedOut = false
    """)
    List<Token> findAllTokensByUser(Integer userId);

    Optional<Token> findByToken(String jwt);
}
