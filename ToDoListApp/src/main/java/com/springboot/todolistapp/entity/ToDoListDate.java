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

    @OneToMany(mappedBy = "toDoListDate", fetch = FetchType.EAGER)
    private List<ToDoListActivity> toDoListActivity;

    @ManyToOne()
    @JoinColumn(name = "user_fk")
    @JsonIgnore
    private User user;

    {
        date = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy"));
    }

}
