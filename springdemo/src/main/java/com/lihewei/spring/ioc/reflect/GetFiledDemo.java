package com.lihewei.spring.ioc.reflect;

import java.lang.reflect.Field;

/**
 * ● Field [] getFields()；获得类中所以public权限的方法；
 *
 * ● Field getField(String name)；根据变量名得到相应的public权限的变量；
 *
 * ● Field [] getDeclaredFields()；获得类中所有的public权限和非public的权限方法 ；
 *
 * ● Field getDeclaredField(String name)；根据方法名获得public权限和非public权限的变量；
 */
public class GetFiledDemo {
    public static void main(String[] args) throws Exception {

        Class<?> c = Class.forName ("com.lihewei.spring.ioc.bean.User");

        Field name = c.getDeclaredField ("userName");
        Field age = c.getDeclaredField ("age");

        Object o = c.newInstance ();

        name.setAccessible (true);
        age.setAccessible (true);

        name.set (o,"张三");
        age.set (o,20);

        System.out.println ("获取到的字段：");
        System.out.println ("name:"+name);
        System.out.println ("age:"+age);
        System.out.println ("字段设置的值:name="+name.get (o)+",age=="+age.get (o));

    }
}
