package com.springboot.todolistapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todolist")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startTime;
    private Date endTime;
    private String activityName;

    private String status;

    @PrePersist
    public void setDefaultStatus() {
        if (status == null || status.isEmpty()) {
            status = "pending";
        }
    }

}
