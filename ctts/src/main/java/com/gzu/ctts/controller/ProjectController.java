package com.gzu.ctts.controller;

import com.gzu.ctts.common.Result;
import com.gzu.ctts.dto.ProjectDTO;
import com.gzu.ctts.entity.Project;
import com.gzu.ctts.exception.BusinessException;
import com.gzu.ctts.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/projects")
@Tag(name = "项目管理")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    @Operation(summary = "获取项目列表")
    @Parameters(value = {
            @Parameter(name = "page", description = "页码", required = true),
            @Parameter(name = "size", description = "每页大小", required = true)
    })
    public Result<List<Project>> projects(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {
        return Result.success(projectService.getAllProjects());
    }

    @PostMapping
    public Result<String> createProject(@RequestBody ProjectDTO projectDTO) {
        Project project = new Project();
        BeanUtils.copyProperties(projectDTO, project);
        projectService.save(project);
        return Result.success(201, "Create project");
    }

    @GetMapping("/{id}")
    public Result<Project> project(@PathVariable Long id) {

        return Result.success(projectService.getById(id));
    }

    @GetMapping("/title")
    public Result<List<Project>> getByTitle(@RequestParam String title) {
        return Result.success(projectService.getByTitle(title));
    }

}
