package com.example.ssdemo.service;

import com.example.ssdemo.domain.ResponseResult;
import com.example.ssdemo.domain.UserDto;

/**
 * @Author Magi
 * @Date 2022/9/1 21:40
 * @Version 1.0
 * @Description
 */
public interface LoginService {
    ResponseResult loign(UserDto userDto);
}
