package com.lihewei.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lihewei.entity.CommonResult;
import com.lihewei.entity.Payment;
import com.lihewei.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


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


    /**
     * 全局统一自定义异常
     * @return
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
    blockHandlerClass = CustomerBlockHandler.class,
    blockHandler = "handlerException2")
    public  CommonResult customerBlockHandler(){
        return  new CommonResult (200,"按客户自定义",new Payment (2020L,"serial003"));
    }


    /**
     *     @SentinelResource(value = "fallback",fallback = "handlerFallBack")//blockhandler只负责sentinel控制台配置违规
     * @param id
     * @return
     */

    /**
     * 若blockexception 和fallback都进行配置，则被限制降级而抛出Blockexception时只会进入bloclhandler处理逻辑
     * @param id
     * @return
     */
    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallBack",
            blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2"
    )//blockhandler只负责sentinel控制台配置违规
    public CommonResult<Payment> fallback(@PathVariable Integer id) {

          Map<Integer,String> map=new HashMap<> ();
            map.put (1,"1qq");
            map.put (2,"2aa");
            map.put (3,"3cc");

        String s = map.get (id);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegaArgumentException ,非法参数异常。。。。");
        } else if (s.equals ("")) {
            throw new NullPointerException ("控制针异常");
        }
        return new CommonResult<> (200, s);
    }

    public  CommonResult handlerFallBack(@PathVariable Integer id,Throwable e){
        Payment payment=new Payment (id.longValue (),null);
        return new CommonResult (444,"兜底异常handlerfallBack内容"+e.getMessage (),payment );
    }
}
