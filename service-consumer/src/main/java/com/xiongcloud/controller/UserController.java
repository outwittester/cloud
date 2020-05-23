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
        return this.restTemplate.getForObject("http://service-provider/user/" + id, User.class);
    }

}
