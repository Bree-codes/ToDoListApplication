package com.springboot.todolistapp.repository;

import com.springboot.todolistapp.entity.ToDoListActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoListActivity,Long> {

    //List<ToDoListActivity> findByUserId(Long userId);

    List<ToDoListActivity> findByUser(Long userId);

}
