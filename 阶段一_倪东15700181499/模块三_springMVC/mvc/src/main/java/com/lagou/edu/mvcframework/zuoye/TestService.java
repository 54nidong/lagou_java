package com.lagou.edu.mvcframework.zuoye;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestService {
    String value() default "";
}
