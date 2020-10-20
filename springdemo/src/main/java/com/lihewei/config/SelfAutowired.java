package com.lihewei.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

@Target ({TYPE,FIELD, ElementType.METHOD})
public @interface SelfAutowired {
}
