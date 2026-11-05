package com.gzu.ctts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gzu.ctts.dto.TaskDTO;
import com.gzu.ctts.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper extends BaseMapper<Task> {
    Task getById(Long id);

    List<Task> selectByOptions(@Param("projectId") Long projectId, @Param("status") Integer status, @Param("title") String title);

    List<Task> selectByStatusList(@Param("statusList") List<Integer> statusList);

    List<Task> selectTaskByOptions(@Param("taskDTO") TaskDTO taskDTO);

    IPage<Task>  selectPageVo(IPage<?> page);

}
