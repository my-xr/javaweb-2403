package com.gzu.ctts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzu.ctts.entity.Task;

public interface TaskMapper extends BaseMapper<Task> {
    Task getById(Long id);
}
