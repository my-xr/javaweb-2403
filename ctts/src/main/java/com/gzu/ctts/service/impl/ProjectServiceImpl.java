package com.gzu.ctts.service.impl;

import com.gzu.ctts.entity.Project;
import com.gzu.ctts.mapper.ProjectMapper;
import com.gzu.ctts.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> getAllProjects() {
        return projectMapper.selectList(null);
    }

    @Override
    public Project getById(Long id) {
        return projectMapper.selectById(id);
    }

    @Override
    public void save(Project project) {
        projectMapper.insert(project);
    }

    @Override
    public List<Project> getByTitle(String title) {
        return projectMapper.getByTitle(title);
    }
}
