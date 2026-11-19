package com.gzu.ctts.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzu.ctts.common.Result;
import com.gzu.ctts.entity.User;
import com.gzu.ctts.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        return Result.success(userService.getUserById(id));
    }

    @GetMapping
    public Result<List<User>> getUsersWithRole(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return Result.success(userService.getUsersWithRole(new Page<>(pageNum, pageSize)));
    }

}
