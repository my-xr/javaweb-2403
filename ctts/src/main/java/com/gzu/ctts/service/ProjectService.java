package com.gzu.ctts.service;

import com.gzu.ctts.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();
    Project getById(Long id);
    void save(Project project);

    List<Project> getByTitle(String title);
}
