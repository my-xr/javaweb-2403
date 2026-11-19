package com.gzu.ctts.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@TableName("sys_role")
public class RoleDTO {

    private Long id;
    private String roleCode;
    private String roleName;
    private String description;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String updateTime;
}
