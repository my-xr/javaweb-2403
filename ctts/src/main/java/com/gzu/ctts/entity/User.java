package com.gzu.ctts.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("sys_user")
public class User {
    private Long id;
    private String username;
    private String password;
    private String realName;
    private String phone;
    private String email;
    private String status;
    private String createTime;
    private String updateTime;

    @TableField(exist = false)
    private List<Role> roles;
}
