package com.lihewei.spring.spring1.servlet;

import com.lihewei.spring.spring1.annotation.Autowired;
import com.lihewei.spring.spring1.annotation.Controller;
import com.lihewei.spring.spring1.annotation.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class DispatchServlet extends HttpServlet {

    private Properties contextConfig=new Properties ();

    private Map<String,Object> beanMap=new ConcurrentHashMap<> ();

    private List<String> beanNames=new ArrayList<> ();

    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost (request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println ("------调用dopost----");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        //开始初始化
        super.init (config);
        //定位
        doLoadConfig(config.getInitParameter ("contextConfigLocation"));

        //加载
        doScanner(contextConfig.getProperty ("scanPackage"));
        //注册
        doRegister();
        //自动依赖注入
        doAutowired();
        //如果是Springmvc会多设计一个HandlerMapping
        //将@RequestMapping 中配置的url和一个method关联上以便于从浏览器获得用户输入url以后，能够找到具体的执行method
        initHandlerMapping();
    }

    private void initHandlerMapping() {
    }

    private void doRegister() {

        if (beanNames.isEmpty ()){
            return;
        }
        try {

            for (String className: beanNames) {
                Class<?> clazz = Class.forName (className);
                if (clazz.isAnnotationPresent (Controller.class)) {
                    String beanName = lowerFirstCase (clazz.getSimpleName ());
                    //在spring中在这个阶段不是不会直接pull instance ，这是put 的是BeanDefinition

                    beanMap.put (beanName, clazz.newInstance ());
                }else  if (clazz.isAnnotationPresent (Service.class)){
                    Service service = clazz.getAnnotation (Service.class);

                    String beanName=service.value ();
                    if("".equals (beanName.trim ())){
                        beanName=lowerFirstCase (clazz.getSimpleName ());
                    }
                    Object instance = clazz.newInstance ();
                    beanMap.put (beanName,instance);

                    Class<?>[] interfaces = clazz.getInterfaces ();
                    for (Class<?> i: interfaces) {

                        beanMap.put (i.getName (),instance);
                    }
                }else {
                    continue;
                }
            }
        }catch (Exception e){
            e.printStackTrace ();
        }


    }

    private void doAutowired() {

        if (beanMap.isEmpty ()){
            return;
        }

        for (Map.Entry<String,Object>  entry:beanMap.entrySet ()) {
            Field[] fields = entry.getValue ().getClass ().getDeclaredFields ();
            for (Field field: fields) {
                if (!field.isAnnotationPresent (Autowired.class)){
                    continue;
                }
                Autowired autowired= field.getAnnotation (Autowired.class);

                String beanName = autowired.value ().trim ();
                if ("".equals (beanName)){
                    beanName = field.getType ().getName ();
                }
                field.setAccessible (true);

                try {
                    field.set (entry.getValue (),beanMap.get (beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace ();
                }
            }
        }
    }



    private void doScanner(String packageName) {
        URL url =this.getClass ().getClassLoader ().getResource ("/"+packageName.replaceAll ("\\.","/"));
        File classDir = new File (url.getFile ());
        for (File file:classDir.listFiles ()) {
            if (file.isDirectory ()){
                doScanner (packageName+"."+file.getName ());
            }else {
                beanNames.add (packageName+"."+file.getName ().replace (".class",""));
            }
        }
    }

    private void doLoadConfig(String location) {
        //在spring中通过reader去查找和定位对不对
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(location.replace("classpath:",""));
        try {
            contextConfig.load (is);

        } catch (IOException e) {
            e.printStackTrace ();
        }finally {
            if (null!=is){
                try {
                    is.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    private  String lowerFirstCase(String str){
        char[] chars=str.toCharArray ();
        chars[0]+=32;
        return String.valueOf (chars);
    }
}
