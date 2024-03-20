package com.springboot.todolistapp.repository;

import com.springboot.todolistapp.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList,Long> {

}
