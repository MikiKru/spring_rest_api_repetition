package com.repetition.rest_api.service;

import com.repetition.rest_api.model.Task;
import com.repetition.rest_api.model.User;
import com.repetition.rest_api.model.enums.Status;
import com.repetition.rest_api.model.enums.Type;
import com.repetition.rest_api.repository.TaskRepository;
import com.repetition.rest_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
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
    public List<Task> getTasksByTypeAndStatusAndUser(Type type, Status status, long userId){
        Optional<User> isUser = userRepository.findById(userId);
        if(isUser.isPresent()) {
            return taskRepository.findAllByUserAndStatusAndType(isUser.get(), status, type);
        }
        return taskRepository.findAllByUserAndStatusAndType(null, status, type);
    }

}
