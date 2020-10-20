package com.lihewei.service;

import com.lihewei.bean.User;
import com.lihewei.config.Component;

@Component
public class UserService {
    public User getUser(){
        User user=new User("张三",20);
        return user;
    }
}
