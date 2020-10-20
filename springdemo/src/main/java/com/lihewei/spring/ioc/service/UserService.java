package com.lihewei.spring.ioc.service;


import com.lihewei.spring.ioc.bean.User;
import com.lihewei.spring.ioc.config.Component;

@Component
public class UserService {
    public User getUser(){
        User user=new User("张三",20);
        return user;
    }
}
