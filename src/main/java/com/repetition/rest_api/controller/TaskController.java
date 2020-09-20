package com.repetition.rest_api.controller;

import com.repetition.rest_api.mapper.TaskMapper;
import com.repetition.rest_api.model.Task;
import com.repetition.rest_api.model.dto.CreateTaskDto;
import com.repetition.rest_api.model.dto.TaskDto;
import com.repetition.rest_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;
    @GetMapping("/tasks")
    public List<TaskDto> getTasks(){
        return taskMapper.toDtos(taskService.getTasks());
    }
    @GetMapping("/tasks/{taskId}")
    public TaskDto getTask(@PathVariable("taskId") long taskId){
        return taskMapper.toDto(taskService.getTask(taskId));
    }
    @PostMapping("/addTask")
    public void createTask(CreateTaskDto createTaskDto){
        taskService.createTask(taskMapper.fromDto(createTaskDto));
    }

}
