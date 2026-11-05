package com.gzu.ctts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gzu.ctts.dao.TaskDAO;
import com.gzu.ctts.dto.TaskDTO;
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

    @Override
    public List<Task> getTasksByOptions(Long projectId, Integer status, String title) {
        return taskMapper.selectByOptions(projectId, status, title);
    }

    @Override
    public List<Task> getTasksByStatusList(List<Integer> statusList) {
        return taskMapper.selectByStatusList(statusList);
    }

    @Override
    public List<Task> getByOptions(TaskDTO taskDTO) {
//        return taskMapper.selectTaskByOptions(taskDTO);
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(taskDTO.getProjectId() != null, Task::getProjectId, taskDTO.getProjectId())
                .like(taskDTO.getTitle() != null, Task::getTitle, taskDTO.getTitle())
                .eq(taskDTO.getStatus() != null, Task::getStatus, taskDTO.getStatus())
                .like(taskDTO.getDescription() != null, Task::getDescription, taskDTO.getDescription())
                .eq(taskDTO.getDeadline() != null, Task::getDeadline, taskDTO.getDeadline())
                .eq(taskDTO.getTotalScore() != null, Task::getTotalScore, taskDTO.getTotalScore())
                .eq(taskDTO.getCreateTime() != null, Task::getCreateTime, taskDTO.getCreateTime())
                .eq(taskDTO.getUpdateTime() != null, Task::getUpdateTime, taskDTO.getUpdateTime())
                .orderByDesc(Task::getCreateTime);

        return taskMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<Task> getTasksByPage(IPage<Task> page) {
        return taskMapper.selectPageVo(page);
    }


}
