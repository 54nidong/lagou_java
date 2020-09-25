package com.lagou.edu.mvcframework.zuoye;

import com.lagou.edu.mvcframework.service.DemoService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在类上添加@TestSecurity注解
 * */

@TestBookController
@TestSecurity({"nidong"})
@TestRequestMapping("/testDemo")
public class TestController {

    @TestAutowired
    private DemoService demoService;

    @TestRequestMapping("find1")
    public String find1(HttpServletRequest request, HttpServletResponse response, String username) {
        return demoService.get(username);
    }

    @TestSecurity({"daoshi"})
    @TestRequestMapping("find2")
    public String find2(HttpServletRequest request, HttpServletResponse response, String username) {
        return demoService.get(username);
    }
}
