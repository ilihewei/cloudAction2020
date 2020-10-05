package com.lihewei.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//这里的属性有可能会更新，git中的配置中心变化就要更新。没有这个注解内，配置就不能及时更想你
@RefreshScope
public class TestController {
    @Value("${version}")
    private String version;

    @GetMapping("/getVersion")
    public String getVersion() {
        return this.version;
    }
}
