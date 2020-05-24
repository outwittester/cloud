package com.xiongcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer/user")
@DefaultProperties(defaultFallback = "defaultFallback")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("{id}")
    @HystrixCommand
    public String queryUserById(@PathVariable("id") Long id) {
        return this.restTemplate.getForObject("http://service-provider/user/" + id, String.class);
    }

    public String defaultFallback() {
        return "busy server, try later, default method";
    }

}
