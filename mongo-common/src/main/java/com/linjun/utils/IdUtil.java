package com.linjun.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 林俊
 * @create 2018/3/9.
 * @desc
 **/
public class IdUtil {
    public  static  String createIdByDate(){
        SimpleDateFormat fmt=new SimpleDateFormat("(yyyyMMddHHmmssSSS)");
        String suffix=fmt.format(new Date());
        suffix=suffix+"-"+Math.round(Math.random()*100000);
        return  suffix;
    }
    public  static  String createIdbyUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
