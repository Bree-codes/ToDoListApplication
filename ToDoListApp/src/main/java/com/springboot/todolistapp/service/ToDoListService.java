package com.springboot.todolistapp.service;

import com.springboot.todolistapp.entity.ToDoListActivity;
import com.springboot.todolistapp.entity.ToDoListDate;
import com.springboot.todolistapp.entity.User;
import com.springboot.todolistapp.repository.DateRepository;
import com.springboot.todolistapp.repository.ToDoListRepository;
import com.springboot.todolistapp.repository.UserRepository;
import com.springboot.todolistapp.request.ToDoListRequest;
import com.springboot.todolistapp.response.ModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;
    private final UserRepository userRepository;
    private final DateRepository dateRepository;
    @Autowired
    public ToDoListService(ToDoListRepository toDoListRepository, UserRepository userRepository, DateRepository dateRepository) {
        this.toDoListRepository = toDoListRepository;
        this.userRepository = userRepository;
        this.dateRepository = dateRepository;
    }


    public ResponseEntity<ModelResponse> createToDoList(List<ToDoListRequest> toDoListRequest,Long user_id){

       List<ToDoListActivity> toDoListActivityList = new ArrayList<>();

        ToDoListDate date = new ToDoListDate();

        date.setDate(toDoListRequest.get(0).getDate());

        /*getting the user.*/
        User user = userRepository.findById(user_id).orElseThrow();


       toDoListRequest.forEach((activity)->{
           ToDoListActivity toDoListActivity = new ToDoListActivity();
           toDoListActivity.setActivityName(activity.getActivityName());
           toDoListActivity.setStartTime(activity.getStartTime());
           toDoListActivity.setEndTime(activity.getEndTime());
           toDoListActivity.setToDoListDate(date);
           toDoListActivity.setUser(user);
          toDoListActivityList.add(toDoListActivity);
               });

        dateRepository.save(date);
        toDoListRepository.saveAll(toDoListActivityList);


        ModelResponse modelResponse = new ModelResponse();

        return new ResponseEntity<>(modelResponse, HttpStatus.CREATED);
    }


}
