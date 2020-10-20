package com.lihewei.spring.ioc;


import com.lihewei.spring.ioc.bean.User;
import com.lihewei.spring.ioc.controller.UserController;
import com.lihewei.spring.ioc.util.IocContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
       Object o = IocContext.applicationContext.get (UserController.class);
        UserController userController= (UserController) o;
        userController.getUser (1);

    }

    public void test() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String classPath="com.lihewei.bean.User";
        Class<?> aClass = Class.forName (classPath);
        Constructor<?> constructor = aClass.getConstructor (String.class, Integer.class);
        User instance =(User) constructor.newInstance("zhangsan",220);
        System.out.println (instance.getAge ());
    }
}
