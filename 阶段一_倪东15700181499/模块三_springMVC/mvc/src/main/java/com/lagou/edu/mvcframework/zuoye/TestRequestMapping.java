package com.lagou.edu.mvcframework.zuoye;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestRequestMapping {
    String value() default "";
}
