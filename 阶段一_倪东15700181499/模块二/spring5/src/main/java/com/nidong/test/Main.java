package com.nidong.test;

import com.nidong.test.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AccountService bean = context.getBean(AccountService.class);
        System.out.println(bean.getAll());//获取所有用户
        bean.toMonkey();//实现转账功能
    }
}
