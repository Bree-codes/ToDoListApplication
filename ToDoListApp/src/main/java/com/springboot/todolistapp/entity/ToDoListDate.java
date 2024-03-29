package com.springboot.todolistapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "date")
public class ToDoListDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String date;

    @ManyToOne()
    @JoinColumn(name = "user_fk")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "toDoListDate")
    @JsonIgnore
    private List<ToDoListActivity> toDoListActivity;

}
