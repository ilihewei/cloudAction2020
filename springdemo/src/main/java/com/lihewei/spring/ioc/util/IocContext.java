package com.lihewei.spring.ioc.util;



import com.lihewei.spring.ioc.config.Component;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IocContext {
    public  static  final Map<Class<?>,Object> applicationContext=new ConcurrentHashMap<> ();

    static {
        String packageName="com.lihewei.spring.ioc";
        try {
            initBean(packageName);
        }catch (Exception e){
            e.printStackTrace ();
        }
    }

    private static void initBean(String packageName) throws IOException, IllegalAccessException {
        Enumeration<URL> urls=Thread.currentThread ().getContextClassLoader ()
                .getResources (packageName.replaceAll ("\\.","/"));

        while (urls.hasMoreElements ()){
            addClassByAnnotation(urls.nextElement ().getPath (),packageName);
        }

        ///ioc 实现自动注入
        IocUtil.inject();

    }

    private static void addClassByAnnotation(String filePath, String packageName) {
        try{
            File[] files=getClassFile(filePath);
            if (files!=null){
                for (File f:files) {
                    String fileName = f.getName ();
                    if (f.isFile ()){
                        Class<?> clazz=Class.forName (packageName+"."+fileName.substring (0,fileName.lastIndexOf (".")));
                        //判断该类是否实现了注解
                        if (clazz.isAnnotationPresent (Component.class)){
                            applicationContext.put (clazz,clazz.newInstance ());
                        }
                    }else {
                        addClassByAnnotation (f.getPath (),packageName+"."+fileName);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (InstantiationException e) {
            e.printStackTrace ();
        }
    }

    private static File[] getClassFile(String filePath) {
        return new File(filePath).listFiles (new FileFilter () {
            @Override
            public boolean accept(File file) {
                return file.isFile ()&&file.getName ().endsWith (".class")||file.isDirectory ();
            }
        });
    }
}
