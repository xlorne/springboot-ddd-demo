package com.example.springboot.demo.service.impl;

import com.example.springboot.demo.domain.Log;
import com.example.springboot.demo.mapper.LogMapper;
import com.example.springboot.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void save(Log log) {
        logMapper.save(log);
    }
}
