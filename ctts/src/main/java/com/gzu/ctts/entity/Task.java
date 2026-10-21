package com.gzu.ctts.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private Long id;
    private Long projectId;
    private String title;
    private String description;
    private LocalDateTime deadline; // 截止时间
    private Integer totalScore;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
