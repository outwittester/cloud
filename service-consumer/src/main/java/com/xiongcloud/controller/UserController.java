package com.xiongcloud.controller;

import com.xiongcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{id}")
    public User queryUserById(@PathVariable("id") Long id) {
        //随机or轮询算法去改变主机
        User user = restTemplate.getForObject("http://localhost:8080/user/" + id, User.class);
        return user;
    }

}
