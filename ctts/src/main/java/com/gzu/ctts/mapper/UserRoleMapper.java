package com.gzu.ctts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzu.ctts.mapper.result.UserRoleResult;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRoleResult> {

    List<UserRoleResult> selectUserRoleList(List<Long> userIds);
}
