package com.xiongcloudprovider.controller;

import com.xiongcloudprovider.model.User;
import com.xiongcloudprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User queryUserbyId(@PathVariable("id") Long id){
        return this.userService.queryUserById(id);
    }
}
