package com.lihewei.spring.ioc.reflect;

import java.lang.reflect.Method;

/**
 * 八、获取类的方法
 * ● Method [] getMethod()；获取所有的public方法，包括继承的
 *
 * ● Method getMethods(String name,Class [] params)；根据方法名和参数获取方法；
 *
 * ● Method [] getDeclaredMethod()；获取所有public权限和非public权限方法，不包含继承的
 *
 * ● Method getDeclaredMethods(String name,Class [] params)；根据方法名和参数类型，获取public权限和非public权限的方法

 *
 *
 * 九、暴力访问 - setAccessible(boolean)
 * 对私有字段的访问取消权限检查。暴力访问（私有的不建议使用）
 *
 *

 */
public class GetMethodDemo {

    public static void main(String[] args) throws Exception {

        Class<?> c = Class.forName("com.lihewei.spring.ioc.reflect.Person");

        //获取公共方法：
        Method[] pubMethods = c.getMethods();

        //获取私有方法：
        Method[] priMethods = c.getDeclaredMethods();


        //获取单个方法：按方法名和参数获取

        //获取单个の静态方法：function1
        Method staMethod = c.getMethod("function1",null);
        //获取单个の无参数方法：function2
        Method nullMethod = c.getMethod("function2",null);
        //获取单个の有参数方法：function3
        Method moreMethod = c.getMethod("function3",String.class);

        //打印查看效果
        System.out.println("[Person类的公共方法及父类方法:]");
        for(Method m:pubMethods){
            System.out.println(m);
        }
        System.out.println("[Person类的私有方法:]");
        for(Method m:priMethods){
            System.out.println(m);
        }
        System.out.println("[按方法名和参数类型获取的方法4个方法:]");
        System.out.println(staMethod);
        System.out.println(nullMethod);
        System.out.println(moreMethod);

    }
}

