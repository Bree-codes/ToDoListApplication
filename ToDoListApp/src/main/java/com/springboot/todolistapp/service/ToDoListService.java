package com.springboot.todolistapp.service;

import com.springboot.todolistapp.entity.ToDoList;
import com.springboot.todolistapp.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;
    @Autowired
    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public List<ToDoList> getAllToDoListItems(){
        return toDoListRepository.findAll();
    }

    public Optional<ToDoList> getToDoItemById(Long id){
        return toDoListRepository.findById(id);
    }
}
