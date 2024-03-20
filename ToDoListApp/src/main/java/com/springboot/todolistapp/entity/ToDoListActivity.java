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
@Table(name = "todolistactivity")
public class ToDoListActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startTime;

    private Date endTime;

    private String activityName;

    //@JsonIgnore
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_fk")
    private User users;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "date_fk")
    private ToDoListDate toDoListDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk")
    private User user;


    @PrePersist
    public void setDefaultStatus() {
        if (status == null || status.isEmpty()) {
            status = "pending";
        }
    }

}
