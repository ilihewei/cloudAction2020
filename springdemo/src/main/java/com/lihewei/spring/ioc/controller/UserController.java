package com.lihewei.spring.ioc.controller;


import com.lihewei.spring.ioc.bean.User;
import com.lihewei.spring.ioc.config.Component;
import com.lihewei.spring.ioc.config.Inject;
import com.lihewei.spring.ioc.service.UserService;

@Component
public class UserController {
    @Inject
    private UserService userService;

    public  void getUser(int age){
        User user=userService.getUser ();
        System.out.println (user);
    }
}
