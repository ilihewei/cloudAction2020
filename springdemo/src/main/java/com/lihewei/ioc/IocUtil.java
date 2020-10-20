package com.lihewei.ioc;

import com.lihewei.config.Inject;

import java.lang.reflect.Field;
import java.util.Map;

public class IocUtil {
    public static void inject() throws IllegalAccessException {
        Map<Class<?>,Object> map=IocContext.applicationContext;
        for (Map.Entry<Class<?>,Object> entry:map.entrySet ()) {
            Class<?> clazz=entry.getKey ();
            Object obj=entry.getValue ();
            Field[] fields = clazz.getDeclaredFields ();

            for (Field field:fields) {

                if (field.isAnnotationPresent (Inject.class)){
                    Class<?> fieldClazz = field.getType ();
                    field.setAccessible (true);
                    Object fieldObj = map.get (fieldClazz);
                    field.set (obj,fieldObj);
                }
            }
        }
    }
}
