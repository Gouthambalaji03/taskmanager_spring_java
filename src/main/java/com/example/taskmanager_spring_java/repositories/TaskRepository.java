package com.example.taskmanager_spring_java.repositories;
import com.example.taskmanager_spring_java.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}
