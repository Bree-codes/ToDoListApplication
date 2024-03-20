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

        log.info("user created a todo list");

       return toDoListService.createToDoList(toDoListRequest,user_id);
    }

    /*@PostMapping("/update")
    public ResponseEntity<String> updateToDoList(@RequestBody ToDoListActivity toDoList){
        try {
            ToDoListActivity updatedToDoList = toDoListService.updateToDoList(toDoList);
            return ResponseEntity.ok("ToDo List Updated Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update ToDo List");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteToDoList(@PathVariable Long id) {
        try {
            toDoListService.deleteToDoList(id);
            return ResponseEntity.ok("ToDo List Deleted Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete ToDo List");

        }*/
    }
