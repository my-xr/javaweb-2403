package com.gzu.ctts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzu.ctts.entity.Project;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProjectMapper extends BaseMapper<Project> {

//    @Select(" SELECT id,title,description,teacher_id,start_date,end_date,status,create_time,update_time FROM training_project " +
//            " WHERE title LIKE CONCAT('%',#{title},'%')")
    List<Project> getByTitle(String title);
}
