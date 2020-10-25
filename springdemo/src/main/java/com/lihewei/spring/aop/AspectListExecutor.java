package com.lihewei.spring.aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

public class AspectListExecutor implements MethodInterceptor {

    //代理的类
    private  Class<?> targetClass;

    //排好序的Aspect列表
    private List<AspectInfo> sortedAspectInfoList;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}
