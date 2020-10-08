package com.lihewei.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
public class ConfigBusApplication {
    public static void main(String[] args) {
        SpringApplication.run (ConfigBusApplication.class,args);
    }
}
