package com.lihewei.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.logging.Logger;

@RestController
public class OrderController {


    @Resource
    private RestTemplate restTemplate;

   // @Value ()
    private String serverUrl="http://nacos-payment-provider";

    @GetMapping(value = "/consumer/nacos/{id}")
    public String getStr(@PathVariable("id") String id){
        return restTemplate.getForObject (serverUrl+"/payment/nacos/"+id,String.class);
    }


}
