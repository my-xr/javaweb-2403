package com.gzu.ctts.controller;

import com.gzu.ctts.common.Result;
import com.gzu.ctts.dto.ProjectDTO;
import com.gzu.ctts.entity.Project;
import com.gzu.ctts.exception.BusinessException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/projects")
@Tag(name = "项目管理")
public class ProjectController {

    @GetMapping
    @Operation(summary = "获取项目列表")
    @Parameters(value = {
            @Parameter(name = "page", description = "页码", required = true),
            @Parameter(name = "size", description = "每页大小", required = true)
    })
    public Result<List<Project>> projects(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {

        List<Project> projects = new ArrayList<>();
        Project project = new Project();
        project.setId(1);
        project.setName("Project 1");
        project.setDesc("This is project 1");
        project.setCreateTime(new Date());
        projects.add(project);

        Project project2 = new Project();
        project2.setId(2);
        project2.setName("Project 2");
        project2.setDesc("This is project 2");
        project2.setCreateTime(new Date());
        projects.add(project2);

        return Result.success(projects);
    }

    @PostMapping
    public Result<String> createProject(@RequestBody ProjectDTO projectDTO) {

        System.out.println("createProject: " + projectDTO.toString());

        return Result.success(201, "Create project");
    }

    @GetMapping("/{id}")
    public Result<Project> project(@PathVariable Integer id) {

        Project project = new Project();
        project.setId(id);
        project.setName("Project 1");
        project.setDesc("This is project 1");
        project.setCreateTime(new Date());

        return Result.success(project);
    }

}
