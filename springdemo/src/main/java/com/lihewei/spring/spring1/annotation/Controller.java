package com.lihewei.spring.spring1.annotation;

import java.lang.annotation.*;

@Target ({ElementType.TYPE})
@Retention (RetentionPolicy.RUNTIME)
@Documented
public @interface Controller {

    String value() default "";
}
