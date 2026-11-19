package com.gzu.ctts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gzu.ctts.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User selectUserByIdWithRole(Long id);

    List<User> selectUsersWithRole(IPage<User> page);


    List<User> selectUsers(IPage<User> page);
}
