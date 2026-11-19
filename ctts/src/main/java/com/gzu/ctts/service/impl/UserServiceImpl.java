package com.gzu.ctts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gzu.ctts.entity.Role;
import com.gzu.ctts.entity.User;
import com.gzu.ctts.mapper.RoleMapper;
import com.gzu.ctts.mapper.UserMapper;
import com.gzu.ctts.mapper.UserRoleMapper;
import com.gzu.ctts.mapper.result.UserRoleResult;
import com.gzu.ctts.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRoleMapper userRoleMapper;

    private final RoleMapper roleMapper;

    @Override
    public User getUserById(Long id) {

        // 查询用户信息，顺便查询用户角色

        // 方案一：先查询用户的详细信息，然后 根据用户ID查询角色ID列表，根据角色ID列表查询角色列表中的角色信息
        // 缺点 多次查询数据库，效率低下
//        User user = userMapper.selectById(id);
//        // 根据用户ID查询角色ID列表
//        LambdaQueryWrapper<UserRoleResult> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(UserRoleResult::getUserId, id);
//        List<UserRoleResult> userRoleResults = userRoleMapper.selectList(lambdaQueryWrapper);
//
//        List<Long> rolesId = userRoleResults.stream().map(UserRoleResult::getRoleId).toList();
//
//        // 根据角色ID列表查询角色列表中的角色信息
//        LambdaQueryWrapper<Role> lambdaQueryWrapper2 = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper2.in(Role::getId, rolesId);
//        List<Role> roles = roleMapper.selectList(lambdaQueryWrapper2);
//
//        user.setRoles(roles);

        // 方案二：多表连接，一次查询用户信息，并且查询其角色详情

        return userMapper.selectUserByIdWithRole(id);
    }

    @Override
    public List<User> getUsersWithRole(IPage<User> page) {

        //1. 先根据user分页
        List<User> users = userMapper.selectUsers(page);
        // 查询userIds 列表，然后 根据用户ID查询角色ID列表，根据角色ID列表查询角色列表中的角色信息
        List<Long> userIds = users.stream().map(User::getId).toList();
        List<UserRoleResult> userRoleResults = userRoleMapper.selectUserRoleList(userIds);

        for(User user : users){
            List<Role> roles = new ArrayList<>();
            for(UserRoleResult userRoleResult : userRoleResults){
                if(userRoleResult.getUserId().equals(user.getId())){
                    Role role = new Role();
                    role.setId(userRoleResult.getRoleId());
                    role.setRoleName(userRoleResult.getRoleName());
                    role.setRoleCode(userRoleResult.getRoleCode());
                    roles.add(role);
                }
            }
            user.setRoles(roles);
        }

        return users;
    }


}
