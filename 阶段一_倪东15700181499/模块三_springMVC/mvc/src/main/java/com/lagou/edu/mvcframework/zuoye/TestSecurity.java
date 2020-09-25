package com.lagou.edu.mvcframework.zuoye;

import java.lang.annotation.*;

/**
 * 设置Security注解
 * */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestSecurity {

    String[] value() default {};
}
