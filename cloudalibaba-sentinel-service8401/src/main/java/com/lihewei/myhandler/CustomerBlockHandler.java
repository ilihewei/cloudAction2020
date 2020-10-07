package com.lihewei.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lihewei.entity.CommonResult;

/**
 * 统一自定义限流异常定义
 * @author  lihewei
 */
public class CustomerBlockHandler {

    public  static CommonResult  handlerException1(BlockException exception){
        return  new CommonResult (4444,"按客户自定义，globalhandlerException");
    }


    public  static CommonResult  handlerException2(BlockException exception){
        return  new CommonResult (5555,"按客户自定义，globalhandlerException");
    }

}
