
package com.example.taskmanager_spring_java.service;

import com.example.taskmanager_spring_java.entities.TaskEntity;

import java.util.List;

public interface TaskService {
    List<TaskEntity> getAllTasks();
    TaskEntity createTask(TaskEntity task);
}
