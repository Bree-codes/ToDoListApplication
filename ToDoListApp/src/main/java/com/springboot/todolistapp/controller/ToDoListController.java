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
@RequestMapping("/api/ToDoList")
@RequiredArgsConstructor
public class ToDoListController {

    private final ToDoListService toDoListService;

    @PostMapping("/create/{user_id}")
    public ResponseEntity<ModelResponse> createToDoList(
            @PathVariable Long user_id,
            @RequestBody List<ToDoListRequest> toDoListRequest) {

        log.info("User created a TODO List");

       return toDoListService.createToDoList(toDoListRequest,user_id);
    }

    @PutMapping("update/{userId}/{activityId}")
    public ResponseEntity<ModelResponse> updateToDoListActivity(
            @PathVariable Long userId, @PathVariable Long activityId,
            @RequestBody ToDoListRequest updatedActivity)
    {
        log.info("User updated TODO List");
       return toDoListService.updateToDoListActivity(userId, activityId, updatedActivity);
    }

    @GetMapping("delete/{userId},{activityId}")
    public ResponseEntity<ModelResponse> deleteToDoListActivity(
            @PathVariable Long userId,@PathVariable Long activityId)
    {
        log.info("User deleting item from the List");
        return toDoListService.deleteToDoListActivity(userId, activityId);
    }

}

