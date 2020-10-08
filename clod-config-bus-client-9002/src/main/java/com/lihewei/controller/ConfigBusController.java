package com.lihewei.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud-example
 * @description:
 * @author:
 * @create: 2018-06-21 10:28
 **/
@RestController
@RefreshScope
public class ConfigBusController {

    @Value("${version}")
    private String version;

    @RequestMapping("/getVersion")
    public String getVersion() {
        return this.version;
    }
}
