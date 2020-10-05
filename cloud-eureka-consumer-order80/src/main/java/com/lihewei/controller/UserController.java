package com.lihewei.controller;

import com.lihewei.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class UserController {

    private Logger logger= LoggerFactory.getLogger (this.getClass ());

    //@Autowired
   // private OrderService orderService;

    @Resource
    RestTemplate restTemplate;

    private static  final  String url="http://CLOUD-ORDER-SERVICE";

    @GetMapping(value = "/{name}")
    public  String name(@PathVariable(value = "name") String name){

        return  restTemplate.getForObject (url+"/"+name,String.class);
       //return orderService.name (name);
    }



    @GetMapping(value="/consumer/payment/zipkin")
    public String paymentZipkin(){
        return "";
    }
}
