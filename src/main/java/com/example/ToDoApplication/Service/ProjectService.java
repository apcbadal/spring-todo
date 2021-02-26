package com.example.ToDoApplication.Service;

import com.example.ToDoApplication.dto.ProjectDto;
import com.example.ToDoApplication.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    void save(Project project);

    List<ProjectDto> findAllProject();
}
