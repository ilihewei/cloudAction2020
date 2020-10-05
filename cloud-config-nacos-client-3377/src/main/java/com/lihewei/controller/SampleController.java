package com.lihewei.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class SampleController {

    @Value("${config}")
    public  String configInfo;


    @GetMapping(value="/configInfo")
    public  String getConfigInfo(){
        return  configInfo;
    }
}
