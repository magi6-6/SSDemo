package com.example.ssdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ssdemo.domain.LoginUser;
import com.example.ssdemo.domain.UserDto;
import com.example.ssdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userMapper.selectOne(new QueryWrapper<UserDto>().eq("user_name", username));
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名不存在");
        }
        List<String> permissions = Arrays.asList("admin","test");
        return LoginUser.builder().userDto(user).permissions(permissions).build();
    }
}
