package com.gzu.ctts.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gzu.ctts.dto.TaskDTO;
import com.gzu.ctts.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    void addTask(Task task);

    Task getById(Long id);

    void updateTask(Task task);

    void deleteById(Long id);

    List<Task> getTasksByOptions(Long projectId, Integer status, String title);

    List<Task> getTasksByStatusList(List<Integer> statusList);

    List<Task> getByOptions(TaskDTO taskDTO);

    IPage<Task> getTasksByPage(IPage<Task> page);
}
