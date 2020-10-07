package com.lihewei.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lihewei.entity.CommonResult;
import com.lihewei.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 1.系统默认的，没有体现出我们自己的业务要求
 * 2.依照现有条件，我们自定义的处理方法又和业务代码耦合在一起，不直观
 * 3.每个业务方法都添加一个兜底的，那代码膨胀
 * 4.全局统一的处理方法没有体现
 */
@RestController
public class RateLimitController {


    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){

        return  new CommonResult (200,"按资源名称限流测试ok",new Payment (2020L,"serial001"));

    }


    public  CommonResult  handleException(BlockException exception){
        return new CommonResult (444,exception.getClass ().getCanonicalName ()+"\t服务不可用");
    }


    /**
     * 流控通过url控制，如果没有自定义就是默认的  Blocked by Sentinel (flow limiting)
     * @return
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){

        return  new CommonResult (200,"按url限流测试ok",new Payment (2020L,"serial002"));

    }
}
