package com.lihewei.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: lihewei
 */
@Component
@FeignClient(value = "CLOUD-ORDER-SERVICE")
public  interface  OrderService {

    @GetMapping("/{name}")
    String name(@PathVariable String name);
}
