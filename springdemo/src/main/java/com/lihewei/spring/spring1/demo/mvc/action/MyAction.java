package com.lihewei.spring.spring1.demo.mvc.action;

import com.lihewei.spring.spring1.annotation.Autowired;
import com.lihewei.spring.spring1.annotation.Controller;
import com.lihewei.spring.spring1.annotation.RequestMapping;
import com.lihewei.spring.spring1.demo.mvc.service.IDemoService;

@Controller
public class MyAction {

    @Autowired
    private  IDemoService demoService;

    @RequestMapping("/query")
    public String query(String name){
        return demoService.get (name);
    }

}
