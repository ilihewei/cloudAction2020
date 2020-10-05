package com.lihewei.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("#{server.port}")
    private  String serverport;

    @GetMapping(value = "name")
    public  String getUserName(){
        return  "user: serverport"+serverport;
    }
}
