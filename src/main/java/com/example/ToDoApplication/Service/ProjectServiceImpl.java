package com.example.ToDoApplication.Service;

import com.example.ToDoApplication.dto.ProjectDto;
import com.example.ToDoApplication.model.Project;
import com.example.ToDoApplication.model.Todo;
import com.example.ToDoApplication.repository.ProjectRepository;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectServiceImpl  implements  ProjectService{
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(Project project) {
        LocalDate createDate=LocalDate.now();
        project.setCreatedDate(createDate);
        for(Todo todo:project.getTodolists()){
            todo.setProject(project);
            todo.setCreatedDate(createDate);
        }
        projectRepository.save(project);
    }

    @Override
    public List<ProjectDto> findAllProject() {
        List<ProjectDto> projectDto=null;
        List<Project> projects = projectRepository.findAll();
        Type targetListType= new TypeToken<List<ProjectDto>>(){}.getType();
        projectDto =modelMapper.map(projects,targetListType);
        return projectDto;
    }
}
