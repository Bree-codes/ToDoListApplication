package com.springboot.todolistapp.service;

import com.springboot.todolistapp.entity.ToDoList;
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

    public Optional<ToDoList> getToDoListById(Long id){
        return toDoListRepository.findById(id);
    }
    public ToDoList createToDoList(ToDoListRequest toDoListRequest){

        ToDoList toDoList = new ToDoList();
        toDoList.setActivityName(toDoListRequest.getActivityName());
        toDoList.setStartTime(toDoListRequest.getStartTime());
        toDoList.setEndTime(toDoListRequest.getEndTime());

        return toDoListRepository.save(toDoList);

    }
    public ToDoList updateToDoList(ToDoList toDoList) {
        return toDoListRepository.save(toDoList);
    }

    public void deleteToDoList(Long id) {
        toDoListRepository.deleteById(id);
    }

}
