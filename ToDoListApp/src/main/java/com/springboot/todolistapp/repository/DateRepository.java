package com.springboot.todolistapp.repository;

import com.springboot.todolistapp.entity.ToDoListDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepository extends JpaRepository<ToDoListDate , Long> {

}
