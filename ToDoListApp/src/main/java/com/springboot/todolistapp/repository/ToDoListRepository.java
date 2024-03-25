package com.springboot.todolistapp.repository;

import com.springboot.todolistapp.entity.ToDoListActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoListActivity,Long> {

    //List<ToDoListActivity> findByUserId(Long userId);

   /* @Query("SELECT t.endTime, t.startTime, t.dateFk, t.id, t.activityName, t.status " +
            "FROM ToDoListApplication.TodolistActivity t WHERE t.userFk = :userId")
    List<ToDoListActivity> findActivityDetailsByUser(@Param("userId") Long userId);
*/
}
