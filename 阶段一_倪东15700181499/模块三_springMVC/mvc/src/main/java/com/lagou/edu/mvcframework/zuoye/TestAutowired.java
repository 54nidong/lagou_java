package com.lagou.edu.mvcframework.zuoye;

import java.lang.annotation.*;

/**
 * 设置Autowired注解
 * */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAutowired {

    String value() default "";
}
