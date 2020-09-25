package com.lagou.edu.mvcframework.zuoye;

import com.lagou.edu.mvcframework.service.DemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在方法上添加@TestSecurity
 * */

@TestBookController
@TestRequestMapping("/methodTest")
public class MethodTestController {

    @TestAutowired
    private DemoService demoService;

    @TestRequestMapping("find1")
    public String find1(HttpServletRequest request, HttpServletResponse response, String username) {
        return demoService.get(username);
    }

    @TestSecurity({"zhangsan", "lisi"})
    @TestRequestMapping("find2")
    public String find2(HttpServletRequest request, HttpServletResponse response, String username) {
        return demoService.get(username);
    }

    @TestSecurity({"tiantian"})
    @TestRequestMapping("find3")
    public String find3(HttpServletRequest request, HttpServletResponse response, String username) {
        return demoService.get(username);
    }
}
