package com.lihewei.controller;

import com.lihewei.bean.User;
import com.lihewei.config.Component;
import com.lihewei.config.Inject;
import com.lihewei.service.UserService;

@Component
public class UserController {
    @Inject
    private UserService userService;

    public  void getUser(){
        User user=userService.getUser ();
        System.out.println (user);
    }
}
