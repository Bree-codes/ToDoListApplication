package com.springboot.todolistapp.controller;

import com.springboot.todolistapp.request.ToDoListRequest;
import com.springboot.todolistapp.response.ModelResponse;
import com.springboot.todolistapp.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todoList")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class ToDoListController {

    private final ToDoListService toDoListService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<ModelResponse> createToDoList(
            @PathVariable Long userId,
            @RequestBody ToDoListRequest toDoListRequest) {

        log.info("User created a TODO List");

       return toDoListService.createToDoList(toDoListRequest,userId);
    }

    @PutMapping("update/{activityId}")
    public ResponseEntity<ModelResponse> updateToDoListActivity(
            @PathVariable Long activityId,
            @RequestBody ToDoListRequest updatedActivity)
    {
        log.info("User updated TODO List");
       return toDoListService.updateToDoListActivity(activityId, updatedActivity);
    }

    @DeleteMapping ("delete/{activityId}")
    public ResponseEntity<ModelResponse> deleteToDoListActivity(
            @PathVariable Long activityId)
    {
        log.info("User deleting item from the List");
        return toDoListService.deleteToDoListActivity(activityId);
    }

    @GetMapping("get/{userId}")
    public ResponseEntity<List<String>> getTodoListDates(@PathVariable Long userId) {
        log.info("Requesting to get the user activities");

        return ResponseEntity.ok(toDoListService.getTodoDates(userId));
    }
}

