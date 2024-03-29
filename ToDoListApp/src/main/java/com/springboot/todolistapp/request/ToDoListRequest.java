package com.springboot.todolistapp.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


import java.io.FileNotFoundException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ToDoListRequest {

    private String activityName;

    private Time startTime;

    private Time endTime;

    @JsonIgnore
    private String date;

    {
        date = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy"));
    }
}
