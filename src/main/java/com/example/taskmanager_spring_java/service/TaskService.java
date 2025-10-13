package com.example.taskmanager_spring_java.service;


import com.example.taskmanager_spring_java.entities.TaskEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskID = 1;

    public void addTask(String title, String description, String deadline) {
        TaskEntity task = new TaskEntity();
        task.setId(taskID);
        task.setTitle(title);
        task.setDescription(description);
        task.setDealline(new Date(deadline)); // 1000: validate date format yyyy-mm-dd
        task.setCompleted(false);
        tasks.add(task);
        taskID++;
    }

    ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

    public TaskEntity getTaskById(int id) {
        for (TaskEntity task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
