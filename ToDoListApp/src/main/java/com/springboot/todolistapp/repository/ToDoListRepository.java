package com.springboot.todolistapp.repository;

import com.springboot.todolistapp.entity.ToDoListActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoListActivity,Long> {

}
