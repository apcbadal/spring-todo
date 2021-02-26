package com.example.ToDoApplication.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "todoList")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniqueId;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "status")
    private boolean status;
    @Basic
    @Column(name = "created_date")
    private LocalDate createdDate;
    @Basic
    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @ManyToOne
    @JoinColumn(name = "project",referencedColumnName = "unique_id")
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

}
