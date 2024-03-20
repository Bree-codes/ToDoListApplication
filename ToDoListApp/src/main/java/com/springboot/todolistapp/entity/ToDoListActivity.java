package com.springboot.todolistapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

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

    //@JsonIgnore
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "date_fk")
    private ToDoListDate toDoListDate;



    @PrePersist
    public void setDefaultStatus() {
        if (status == null || status.isEmpty()) {
            status = "pending";
        }
    }

}
