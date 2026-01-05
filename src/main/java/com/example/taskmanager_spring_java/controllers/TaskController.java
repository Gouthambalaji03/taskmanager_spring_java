
package com.example.taskmanager_spring_java.controllers;

import com.example.taskmanager_spring_java.entities.TaskEntity;
import com.example.taskmanager_spring_java.service.TaskService;
import com.example.taskmanager_spring_java.serviceImpl.TaskServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskEntity>> getTasks() {
        var tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskEntity task) {
        var created = taskService.createTask(task);
        return ResponseEntity.status(201).body(created);
    }
}
