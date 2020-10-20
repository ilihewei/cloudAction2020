package com.lihewei.spring.ioc.reflect;

import java.lang.reflect.Constructor;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取字节码对象的三种方式
        /**
         * Class c = 对象.getClass()；已经创建对象一般不需要进行反射
         * Class c = 类名.class；需要导入类的包，依赖性太强
         * Class c = Class.forName("package.className")；使用字符串获取(含包名)，一般开发中选择这种★
         */
        Class<?> person=Class.forName ("com.lihewei.spring.ioc.bean.User");
        try {


            /**
             *获取类的构造函数
             *  ● Constructor [] getConstructors()；获取public权限的所有构造器
             *
             * ● Constructor getConstructor(Class<?>...params)；根据指定参数获得public权限的构造器
             *
             * ● Constructor [] getDeclaredConstructors()；获取public权限的所有构造器
             *
             * ● Constructor getDeclaredConstructor(Class<?>...params)；根据指定参数获得public权限和非public权限的构造器
             */


            //Constructor constructor = person.getConstructor (int.class,String.class);

            //使用class对象创建该对象的实例
            Object obj=person.newInstance ();

        } catch (InstantiationException e) {
            e.printStackTrace ();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        }
    }
}
