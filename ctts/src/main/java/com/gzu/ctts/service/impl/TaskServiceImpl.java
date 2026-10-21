package com.gzu.ctts.service.impl;

import com.gzu.ctts.dao.TaskDAO;
import com.gzu.ctts.entity.Task;
import com.gzu.ctts.mapper.TaskMapper;
import com.gzu.ctts.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> getTasks() {
        return taskMapper.selectList(null);
    }

    @Override
    public void addTask(Task task) {
        taskMapper.insert(task);
    }

    @Override
    public Task getById(Long id) {
        return taskMapper.getById(id);
    }

    @Override
    public void updateTask(Task task) {
        taskMapper.updateById(task);
    }

    @Override
    public void deleteById(Long id) {
        taskMapper.deleteById(id);
    }


}
