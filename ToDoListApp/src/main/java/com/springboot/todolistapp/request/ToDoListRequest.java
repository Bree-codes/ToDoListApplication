package com.springboot.todolistapp.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ToDoListRequest {

    private String activityName;

    private Time startTime;

    private Time endTime;

    @JsonIgnore
    private Date date;

    @PostConstruct
    private void setDate(){
        this.date = new Date();
    }

}
