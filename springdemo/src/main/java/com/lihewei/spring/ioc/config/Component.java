package com.lihewei.spring.ioc.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指定需要容器所需要的类
 */
@Target ({ElementType.TYPE})
@Retention (RetentionPolicy.RUNTIME)
public @interface Component {
}
