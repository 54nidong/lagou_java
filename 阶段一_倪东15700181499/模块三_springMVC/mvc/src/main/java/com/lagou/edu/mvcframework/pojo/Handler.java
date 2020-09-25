package com.lagou.edu.mvcframework.pojo;

import com.lagou.edu.mvcframework.zuoye.MvcException;

import javax.sound.midi.MetaEventListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;


/**
 * 封装handler方法相关的信息
 */
public class Handler {

    private Object controller; // method.invoke(obj,)

    private Method method;

    private Pattern pattern; // spring中url是支持正则的

    private Map<String,Integer> paramIndexMapping; // 参数顺序,是为了进行参数绑定，key是参数名，value代表是第几个参数 <name,2>

    private Set<String> userNameSet; // 用户名存储集合


    public Handler(Object controller, Method method, Pattern pattern) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
        this.paramIndexMapping = new HashMap<>();
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Map<String, Integer> getParamIndexMapping() {
        return paramIndexMapping;
    }

    public void setParamIndexMapping(Map<String, Integer> paramIndexMapping) {
        this.paramIndexMapping = paramIndexMapping;
    }

    public Object invoke(String userName, Object... args) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, MvcException {
        // 若不匹配则 throw new MvcException
        if (userNameSet == null || !userNameSet.contains(userName)) {
            throw new MvcException(userName + " 未授权登录");
        }
        return this.method.invoke(this.controller, args);
    }
}
