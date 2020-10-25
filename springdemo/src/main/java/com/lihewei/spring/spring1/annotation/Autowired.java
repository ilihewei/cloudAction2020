package com.lihewei.spring.spring1.annotation;

import java.lang.annotation.*;

@Target ({ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {
    String value() default "";
}
