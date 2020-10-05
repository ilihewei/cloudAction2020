package com.lihewei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author  lihewei
 */
@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
public class ConfigApplciation7008 {
    public static void main(String[] args) {
        SpringApplication.run (ConfigApplciation7008.class,args);
    }
}
