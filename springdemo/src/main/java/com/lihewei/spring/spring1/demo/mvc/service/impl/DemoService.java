package com.lihewei.spring.spring1.demo.mvc.service.impl;

import com.lihewei.spring.spring1.demo.mvc.service.IDemoService;

public class DemoService implements IDemoService {
    @Override
    public String get(String name) {
        return "my name is "+name;
    }
}
