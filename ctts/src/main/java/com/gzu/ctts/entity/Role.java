package com.gzu.ctts.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_role")
public class Role {

    private Long id;
    private String roleCode;
    private String roleName;
    private String description;
    private String status;
    private String createTime;
    private String updateTime;
}
