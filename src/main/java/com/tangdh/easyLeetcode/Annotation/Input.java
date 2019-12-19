package com.tangdh.easyLeetcode.Annotation;

import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = Inputs.class)
public @interface Input {
    String container() default "array";
    String value() ;
    String type()     default "int";
}

