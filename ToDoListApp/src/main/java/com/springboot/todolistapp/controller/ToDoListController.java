package com.springboot.todolistapp.controller;

import com.springboot.todolistapp.entity.ToDoListActivity;
import com.springboot.todolistapp.request.ToDoListRequest;
import com.springboot.todolistapp.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ToDoList")
public class ToDoListController {

    private final ToDoListService toDoListService;

    @Autowired
    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createToDoList(@RequestBody ToDoListRequest toDoListRequest) {
        //return toDoListService.createToDoList(toDoListRequest);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body("ToDo List Created Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create ToDo List");
        }
    }

    @PostMapping("/update")
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
        }
    }
}