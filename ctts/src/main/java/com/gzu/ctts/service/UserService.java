package com.gzu.ctts.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gzu.ctts.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    List<User> getUsersWithRole(IPage<User> page);
}
