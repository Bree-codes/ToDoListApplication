package com.springboot.todolistapp.service;

import com.springboot.todolistapp.entity.ToDoListActivity;
import com.springboot.todolistapp.entity.ToDoListDate;
import com.springboot.todolistapp.repository.ToDoListRepository;
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
    @Autowired
    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public Optional<ToDoListActivity> getToDoListById(Long id){
        return toDoListRepository.findById(id);
    }
    public ResponseEntity<ModelResponse> createToDoList(List<ToDoListRequest> toDoListRequest,Long user_id){

       List<ToDoListActivity> toDoListActivityList = new ArrayList<>();

        ToDoListDate date = new ToDoListDate();

       toDoListRequest.forEach((activity)->{
           ToDoListActivity toDoListActivity = new ToDoListActivity();
           toDoListActivity.setActivityName(activity.getActivityName());
           toDoListActivity.setStartTime(activity.getStartTime());
           toDoListActivity.setEndTime(activity.getEndTime());

          toDoListActivityList.add(toDoListActivity);
               });

       date.setDate(toDoListRequest.getFirst().getDate());
       date.setToDoListActivity(toDoListActivityList);


        ModelResponse modelResponse = new ModelResponse();

        return new ResponseEntity<>(modelResponse, HttpStatus.CREATED);
    }
    public ToDoListActivity updateToDoList(ToDoListActivity toDoList) {
        return toDoListRepository.save(toDoList);
    }

    public void deleteToDoList(Long id) {
        toDoListRepository.deleteById(id);
    }

}
