package com.example.ToDoApplication.dto;

import com.example.ToDoApplication.model.Todo;

import java.time.LocalDate;
import java.util.List;

public class ProjectDto {
    private Long uniqueId;
    private String title;
    private LocalDate createdDate;
    private List<TodoDto> todolists;

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public List<TodoDto> getTodolists() {
        return todolists;
    }

    public void setTodolists(List<TodoDto> todolists) {
        this.todolists = todolists;
    }


}
