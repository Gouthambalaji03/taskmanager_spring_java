package com.example.taskmanager_spring_java.serviceImpl;
import com.example.taskmanager_spring_java.service.TaskService;
import com.example.taskmanager_spring_java.entities.TaskEntity;
import com.example.taskmanager_spring_java.repositories.TaskRepository;
import com.example.taskmanager_spring_java.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repo;

    public TaskServiceImpl(TaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<TaskEntity> getAllTasks() {
        return repo.findAll();
    }

    @Override
    public TaskEntity createTask(TaskEntity task) {
        return repo.save(task);
    }
}

