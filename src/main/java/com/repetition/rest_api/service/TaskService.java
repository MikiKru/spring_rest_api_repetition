package com.repetition.rest_api.service;

import com.repetition.rest_api.model.Task;
import com.repetition.rest_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }
    public Task getTask(long taskId){
        return taskRepository.findById(taskId)
                .orElseGet(() -> new Task(0,null,null,null,null,null));
    }

}
