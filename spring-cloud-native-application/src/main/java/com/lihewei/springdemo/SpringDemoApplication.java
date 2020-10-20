package com.lihewei.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemoApplication {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext ("applicationContext.xml");
        Login login =(Login) ctx.getBean ("login");
        login.login1 ();
    }
}
