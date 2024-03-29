package com.springboot.todolistapp.service;

import com.springboot.todolistapp.CustomExceptions.ActivityNotFoundException;
import com.springboot.todolistapp.entity.ToDoListActivity;
import com.springboot.todolistapp.entity.ToDoListDate;
import com.springboot.todolistapp.entity.User;
import com.springboot.todolistapp.repository.DateRepository;
import com.springboot.todolistapp.repository.ToDoListRepository;
import com.springboot.todolistapp.repository.UserRepository;
import com.springboot.todolistapp.request.ToDoListRequest;
import com.springboot.todolistapp.response.ModelResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;
    private final UserRepository userRepository;
    private final DateRepository dateRepository;
    @Autowired
    public ToDoListService(ToDoListRepository toDoListRepository,
                           UserRepository userRepository,
                           DateRepository dateRepository) {
        this.toDoListRepository = toDoListRepository;
        this.userRepository = userRepository;
        this.dateRepository = dateRepository;
    }


    public ResponseEntity<ModelResponse> createToDoList(ToDoListRequest toDoListRequest, Long user_id){

        ToDoListDate date = new ToDoListDate();
        /*getting the user.*/
        User user = userRepository.findById(user_id).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );

        if(dateRepository.findByDate(date.getDate()).orElse(null) == null) {
            date.setUser(user);
            dateRepository.save(date);
        }else {
            date = dateRepository.findByDate(date.getDate()).orElseThrow();
        }

        ToDoListActivity toDoListActivity = new ToDoListActivity();
        toDoListActivity.setToDoListDate(date);
        toDoListActivity.setEndTime(toDoListRequest.getEndTime());
        toDoListActivity.setStartTime(toDoListRequest.getStartTime());
        toDoListActivity.setActivityName(toDoListRequest.getActivityName());

        toDoListRepository.save(toDoListActivity);

        ModelResponse modelResponse = new ModelResponse();

        modelResponse.setDate(new Date());
        modelResponse.setStatus(HttpStatus.CREATED);
        modelResponse.setMessage("Your TODO List has been Created Successfully!");

        return new ResponseEntity<>(modelResponse, HttpStatus.CREATED);
    }


    public ResponseEntity<ModelResponse> updateToDoListActivity(
            Long activityId, ToDoListRequest updatedToDoList)
    {
        // Retrieve the todo list activity to be updated
        ToDoListActivity todoActivity = toDoListRepository.findById(activityId)
                .orElseThrow(() -> new ActivityNotFoundException("Todo list activity not found!"));


        // Update the fields of the todo list activity
        todoActivity.setActivityName(updatedToDoList.getActivityName());
        todoActivity.setStartTime(updatedToDoList.getStartTime());
        todoActivity.setEndTime(updatedToDoList.getEndTime());

        // Save the updated todo list activity
        toDoListRepository.save(todoActivity);

        ModelResponse modelResponse = new ModelResponse();

        modelResponse.setDate(new Date());
        modelResponse.setStatus(HttpStatus.OK);
        modelResponse.setMessage("Your TODO List has been Updated Successfully!");

        return new ResponseEntity<>(modelResponse, HttpStatus.OK);
    }

    public ResponseEntity<ModelResponse> deleteToDoListActivity(Long activityId){


        // Retrieve the todo list activity to be deleted
        ToDoListActivity todoActivity = toDoListRepository.findById(activityId)
                .orElseThrow(() -> new ActivityNotFoundException("Todo list activity not found!"));


        //delete the activity
        toDoListRepository.delete(todoActivity);

        ModelResponse modelResponse = new ModelResponse();
        modelResponse.setDate(new Date());
        modelResponse.setStatus(HttpStatus.OK);
        modelResponse.setMessage("Activity Deleted Successfully!");

        return new ResponseEntity<>(modelResponse,HttpStatus.OK);

    }

    public List<ToDoListActivity> getToDoListActivitiesByUserId(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        log.info("Getting the user.");

        /*Getting the todolist.*/
        List<String> toDoListDates = dateRepository.findDatesByUser(user).orElseThrow();



        return null;
    }


}

