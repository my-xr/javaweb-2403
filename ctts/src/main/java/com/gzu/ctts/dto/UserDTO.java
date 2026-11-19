package com.gzu.ctts.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@TableName("sys_user")
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String realName;
    private String phone;
    private String email;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String updateTime;

}
