package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihewei
 */
@RestController
public class UserController {


    @Value ("${server.port}")
    private  String port;

    @GetMapping(value = "/{name}")
    public String name(@PathVariable String name){
        return "name===>"+name+"==="+port;
    }
}
