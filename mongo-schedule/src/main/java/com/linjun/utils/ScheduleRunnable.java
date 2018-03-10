package com.linjun.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
public class ScheduleRunnable implements  Runnable {
    private Object torget;
    private Method method;
    private  String params;

    public ScheduleRunnable(Object torget, String methodname, String params) throws NoSuchMethodException {
        this.torget = torget;

        this.params = params;
        if (StringUtils.isNotBlank(params)){
            this.method=torget.getClass().getDeclaredMethod(methodname, String.class);
        }else {
            this.method=torget.getClass().getDeclaredMethod(methodname);
        }
    }

    @Override
    public void run() {
        try {
            ReflectionUtils.makeAccessible(method);
            if (StringUtils.isNotBlank(params)) {
                method.invoke(torget, params);
            } else {
                method.invoke(torget);
            }
        } catch (Exception e) {
            throw new RRException("执行定时任务失败", e);
        }
    }
}


