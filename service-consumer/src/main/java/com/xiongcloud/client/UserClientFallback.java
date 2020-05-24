package com.xiongcloud.client;

import com.xiongcloud.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserClientFallback implements UserClient {
    //better to return string type
    @Override
    public User queryUserbyId(Long id) {
        User user = new User();
        user.setUsername("Client is too busy to work");
        user.setCreated(new Date());
        return user;
    }
}
