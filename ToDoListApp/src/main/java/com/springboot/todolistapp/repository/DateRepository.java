package com.springboot.todolistapp.repository;

import com.springboot.todolistapp.entity.ToDoListDate;
import com.springboot.todolistapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Repository
public interface DateRepository extends JpaRepository<ToDoListDate , Long> {

    Optional<ToDoListDate> findByDate(String date);

    @Transactional
    @Query("select t.date from ToDoListDate t where t.user = :user")
    Optional<List<String>> findDatesByUser(User user);
}
