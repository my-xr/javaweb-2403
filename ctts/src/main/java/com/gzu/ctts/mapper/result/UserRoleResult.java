package com.gzu.ctts.mapper.result;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user_role")
public class UserRoleResult {
    private Long id;
    private Long userId;
    private Long roleId;
    private String roleName;
    private String roleCode;
}
