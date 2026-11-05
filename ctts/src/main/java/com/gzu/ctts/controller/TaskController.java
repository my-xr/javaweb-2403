package com.gzu.ctts.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzu.ctts.common.Result;
import com.gzu.ctts.dao.TaskDAO;
import com.gzu.ctts.dto.TaskDTO;
import com.gzu.ctts.entity.Task;
import com.gzu.ctts.service.TaskService;
import com.gzu.ctts.service.impl.TaskServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public Result<List<Task>> getTasks(){
        return Result.success(taskService.getTasks());
    }

    @PostMapping
    public Result<String> addTask(@RequestBody TaskDTO taskDTO){

        Task task = new Task();

        BeanUtils.copyProperties(taskDTO, task);

        taskService.addTask(task);
        return Result.success("添加成功");
    }

    @GetMapping("/{id}")
    public Result<Task> getTask(@PathVariable Long id){
        return Result.success(taskService.getById(id));
    }

    @PutMapping("/{id}")
    public Result<String> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        Task task = new Task();
        BeanUtils.copyProperties(taskDTO, task);
        task.setId(id);
        taskService.updateTask(task);
        return Result.success("修改成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteTask(@PathVariable Long id){
        taskService.deleteById(id);
        return Result.success("删除成功");
    }

    @GetMapping("/options")
    public Result<List<Task>> getTasksByOptions(@RequestParam(required = false) Long projectId, @RequestParam(required = false) Integer status, @RequestParam(required = false) String title){
        return Result.success(taskService.getTasksByOptions(projectId, status, title));
    }

    @GetMapping("/status")
    public Result<List<Task>> getTasksByStatusList(@RequestParam List<Integer> statusList){
        return Result.success(taskService.getTasksByStatusList(statusList));
    }

    @PostMapping("/getByOptions")
    public Result<List<Task>> getTasksByOptions(@RequestBody TaskDTO taskDTO){
        return Result.success(taskService.getByOptions(taskDTO));
    }

    @GetMapping("/page")
    public Result<IPage<Task>> getTasksByPage(@RequestParam int pageNum, @RequestParam int pageSize){
        IPage<Task> page = new Page<>(pageNum, pageSize);
        return Result.success(taskService.getTasksByPage(page));
    }

}
