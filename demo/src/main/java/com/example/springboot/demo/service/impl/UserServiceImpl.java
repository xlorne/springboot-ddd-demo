package com.example.springboot.demo.service.impl;

import com.example.springboot.demo.domain.User;
import com.example.springboot.demo.mapper.UserMapper;
import com.example.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

}
