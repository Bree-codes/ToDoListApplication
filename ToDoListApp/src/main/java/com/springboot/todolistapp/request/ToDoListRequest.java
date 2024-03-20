package com.springboot.todolistapp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoListRequest {

    private String activityName;
    private Date startTime;
    private Date endTime;


}
