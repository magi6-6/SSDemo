package com.example.ssdemo.service.impl;

import com.example.ssdemo.domain.LoginUser;
import com.example.ssdemo.domain.ResponseResult;
import com.example.ssdemo.domain.UserDto;
import com.example.ssdemo.service.LoginService;
import com.example.ssdemo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author Magi
 * @Date 2022/9/1 21:40
 * @Version 1.0
 * @Description
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseResult loign(UserDto userDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDto.getUserName(), userDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登陆失败");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String jwt = JwtUtil.createJWT(loginUser.getUserDto().getId().toString());
        redisTemplate.opsForValue().set("login:" + jwt, loginUser);
        return ResponseResult.success("登陆成功");
    }
}
