package com.springboot.todolistapp.service;

import com.springboot.todolistapp.CustomExceptions.ActivityNotFoundException;
import com.springboot.todolistapp.CustomExceptions.DateConversionException;
import com.springboot.todolistapp.entity.ToDoListActivity;
import com.springboot.todolistapp.entity.ToDoListDate;
import com.springboot.todolistapp.entity.User;
import com.springboot.todolistapp.repository.DateRepository;
import com.springboot.todolistapp.repository.ToDoListRepository;
import com.springboot.todolistapp.repository.UserRepository;
import com.springboot.todolistapp.request.ToDoListRequest;
import com.springboot.todolistapp.response.ModelResponse;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;
    private final UserRepository userRepository;
    private final DateRepository dateRepository;

    private ModelResponse modelResponse;

    @PostConstruct
    public void init(){
        modelResponse = new ModelResponse();
    }

    @Autowired
    public ToDoListService(ToDoListRepository toDoListRepository,
                           UserRepository userRepository,
                           DateRepository dateRepository) {
        this.toDoListRepository = toDoListRepository;
        this.userRepository = userRepository;
        this.dateRepository = dateRepository;
    }


    public ResponseEntity<ModelResponse> createToDoList(ToDoListRequest toDoListRequest, Long user_id){

        /*getting the user.*/
        User user = userRepository.findById(user_id).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );

        //the date of creation of the todoList
        ToDoListDate toDoListDate = dateRepository.findByDateAndUser(toDoListRequest.getDate(), user).orElse(null);

        /*check if the existing another activity assigned for that day*/
        if( toDoListDate == null) {

            toDoListDate = new ToDoListDate();

            toDoListDate.setUser(user);
            toDoListDate.setDate(toDoListRequest.getDate());

            dateRepository.save(toDoListDate);
        }


        ToDoListActivity toDoListActivity = new ToDoListActivity();

        toDoListActivity.setToDoListDate(toDoListDate);
        toDoListActivity.setEndTime(toDoListRequest.getEndTime());
        toDoListActivity.setStartTime(toDoListRequest.getStartTime());
        toDoListActivity.setActivityName(toDoListRequest.getActivityName());

        //saving the new activity
        toDoListRepository.save(toDoListActivity);

        modelResponse.setDate(new Date());
        modelResponse.setStatus(HttpStatus.CREATED);
        modelResponse.setMessage("Your TODOList has been created successfully!");

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

        modelResponse.setDate(new Date());
        modelResponse.setStatus(HttpStatus.OK);
        modelResponse.setMessage("Activity Deleted Successfully!");

        return new ResponseEntity<>(modelResponse,HttpStatus.OK);

    }

    public List<String> getTodoDates(Long userId) {

        log.info("Getting the user.");
        User user = userRepository.findById(userId).orElse(null);

        //date formatter oobject
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");


        /*Getting the todolist.*/
        List<String> toDoListDates = dateRepository.findDatesByUser(user).orElseThrow();

        //List to hold dates for sorting
        List<Date> dateTimes = new ArrayList<>();

        //convert the string dates into Date class objects.
        toDoListDates.forEach((date) -> {
            try {
                dateTimes.add(dateFormat.parse(date));

            } catch (ParseException e) {
                log.error(e+"");
                throw new DateConversionException("Invalid date passed");
            }
        });

        log.info("sorting the dates");
        //sort the dates
        Collections.sort(dateTimes);

        //clear the toDoListDates list.
        toDoListDates = new ArrayList<>();

        //list to hold new formatted dates.
        List<String> sortedToDoListDates = toDoListDates;

        dateTimes.forEach((date) -> sortedToDoListDates
                .add(dateFormat.format(date)));

        log.info("dates retrieved successfully");
        return sortedToDoListDates;
    }


}

