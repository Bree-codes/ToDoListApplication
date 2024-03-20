package com.springboot.todolistapp.service;

import com.springboot.todolistapp.entity.ToDoListActivity;
import com.springboot.todolistapp.repository.ToDoListRepository;
import com.springboot.todolistapp.request.ToDoListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ToDoListActivity createToDoList(ToDoListRequest toDoListRequest){

        ToDoListActivity toDoList = new ToDoListActivity();
        toDoList.setActivityName(toDoListRequest.getActivityName());
        toDoList.setStartTime(toDoListRequest.getStartTime());
        toDoList.setEndTime(toDoListRequest.getEndTime());

        return toDoListRepository.save(toDoList);

    }
    public ToDoListActivity updateToDoList(ToDoListActivity toDoList) {
        return toDoListRepository.save(toDoList);
    }

    public void deleteToDoList(Long id) {
        toDoListRepository.deleteById(id);
    }

}
