package com.example.ToDoApplication.repository;

import com.example.ToDoApplication.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
