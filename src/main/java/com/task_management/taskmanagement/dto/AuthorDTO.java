package com.task_management.taskmanagement.dto;


public class AuthorDTO {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
