package com.springboot.todolistapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todolistactivity")
public class ToDoListActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Time startTime;

    private Time endTime;

    private String activityName;

    private String status;


    @ManyToOne
    @JoinColumn(name = "date_fk")
    private ToDoListDate toDoListDate;

    @PrePersist
    public void setDefaultStatus() {
        if (status == null || status.isEmpty()) {
            status = "pending";
        }
    }

}
