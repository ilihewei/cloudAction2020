package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class DemoApplication7003 {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication7003.class, args);
	}

}
