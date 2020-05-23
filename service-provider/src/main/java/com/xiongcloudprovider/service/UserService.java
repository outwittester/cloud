package com.xiongcloudprovider.service;

import com.xiongcloudprovider.mapper.UserMapper;
import com.xiongcloudprovider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
