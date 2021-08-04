package com.ycit.controller;

import com.ycit.bean.command.UserAddCommand;
import com.ycit.bean.dto.UserDto;
import com.ycit.bean.entity.User;
import com.ycit.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author racy
 * @date 2021/8/1
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/users")
    public void addUser(@RequestBody UserAddCommand userAddCommand) {
        userService.insert(userAddCommand);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.finds();
    }

}
