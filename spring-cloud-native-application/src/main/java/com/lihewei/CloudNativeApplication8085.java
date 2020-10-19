package com.lihewei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CloudNativeApplication8085 {
    public static void main(String[] args) {
        SpringApplication.run (CloudNativeApplication8085.class,args);
    }
}
