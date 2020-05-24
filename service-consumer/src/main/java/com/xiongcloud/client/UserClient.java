package com.xiongcloud.client;

import com.xiongcloud.model.User;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//method definition is the the same as the one wants to be called, check service provider
@FeignClient("service-provider")
public interface UserClient {
    //avoid use global path of RequestMapping, dynamic proxy
    @LoadBalanced
    @GetMapping("user/{id}")
    User queryUserbyId(@PathVariable("id") Long id);
}
