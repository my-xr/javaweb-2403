package com.gzu.ctts.service;

import com.gzu.ctts.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    void addTask(Task task);

    Task getById(Long id);

    void updateTask(Task task);

    void deleteById(Long id);

}
