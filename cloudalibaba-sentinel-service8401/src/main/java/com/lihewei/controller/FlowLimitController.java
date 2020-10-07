package com.lihewei.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {
    private Logger logger= LoggerFactory.getLogger (this.getClass ());

    @GetMapping("/testA")
    public  String testA(){
        return "------------testA";
    }

    @GetMapping("/testB")
    public  String testB(){
        System.out.println (Thread.currentThread ().getName ()+"-------testB");
        return "___________testB";
    }

    @GetMapping("testD")
    public  String testD(){
        try {
            TimeUnit.SECONDS.sleep (1);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        logger.info ("test D 测试RT");
        return "---------testD";
    }

    @GetMapping("testE")
    public  String testE(){
        logger.info ("test 测试异常数");
        int age=10/0;
        return "-----testE 测试异常数";

    }



    @GetMapping("testHotkey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value ="p1",required = false )String P1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "-------testHotkey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return " ---deal_testHotKey";
        //sentinel 默认的提示
    }
}
