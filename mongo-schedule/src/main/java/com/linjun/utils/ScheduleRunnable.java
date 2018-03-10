package com.linjun.utils;

import org.apache.commons.lang.StringUtils;

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

    public ScheduleRunnable(Object torget, Method method, String params) {
        this.torget = torget;
        this.method = method;
        this.params = params;
        if (StringUtils.isNotBlank(params))
    }

    @Override
    public void run() {

    }
}


