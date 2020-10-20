package com.lihewei;

import com.lihewei.bean.User;
import com.lihewei.controller.UserController;
import com.lihewei.ioc.IocContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Object o = IocContext.applicationContext.get (UserController.class);
//        UserController userController= (UserController) o;
//        userController.getUser ();
        String classPath="com.lihewei.bean.User";
        Class<?> aClass = Class.forName (classPath);
        Constructor<?> constructor = aClass.getConstructor (String.class, Integer.class);
        User instance =(User) constructor.newInstance("zhangsan",220);
        System.out.println (instance.getAge ());
    }
}
