package com.linjun.utils;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

/**
 * @author 林俊
 * @create 2018/3/9.
 * @desc
 **/
public class ResourceUtil {
    private  static  ResourceUtil RESOURCE_UTIL=null;
    private  static ResourceBundle BUNDLE=ResourceBundle.getBundle("platform");
    private ResourceUtil(){

    }
    public  static  ResourceUtil getInstance(String properties){
        if (RESOURCE_UTIL==null){
            RESOURCE_UTIL=new ResourceUtil();
        }
        if (properties!=null){
            BUNDLE=ResourceBundle.getBundle(properties);
        }
        return RESOURCE_UTIL;
    }
    public  static  ResourceUtil getInstance(){
        if (RESOURCE_UTIL==null){
            RESOURCE_UTIL=new ResourceUtil();
        }
        return RESOURCE_UTIL;
    }
   public  static  String getConfigByName(String name){
        String values="";
       try {
           values=new String(BUNDLE.getString(name).getBytes("iso8859-1"),"UTF-8");
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }
       return  values;
   }

   public  static  String getSeparator(){
        return System.getProperty("file.separator");
   }

}
