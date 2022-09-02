package com.example.ssdemo.controller;

import com.example.ssdemo.domain.ResponseResult;
import com.example.ssdemo.domain.UserDto;
import com.example.ssdemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Magi
 * @Date 2022/9/1 21:37
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody UserDto userDto) {
        return loginService.login(userDto);
    }
}
