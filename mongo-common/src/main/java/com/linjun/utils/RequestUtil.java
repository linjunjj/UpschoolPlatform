package com.linjun.utils;




import org.json.JSONObject;
import com.linjun.Global;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author 林俊
 * @create 2018/3/9.
 * @desc
 **/
public class RequestUtil {
    private  static  final Logger logger=Logger.getLogger(RequestUtil.class.getName());
    public  static Map<String,Object> getParameters(HttpServletRequest request,boolean printLog){
        Enumeration<String> enume=request.getParameterNames();
        Map<String,Object> map=new HashMap<>();
        while (enume.hasMoreElements()){
            String key=enume.nextElement();
            String value=request.getParameter(key);
            map.put(key,value);
            if (printLog){
                logger.info(key+"==>"+value);
            }
        }
        if (map.get(Global.SORT_ORDER) != null) {
            map.put(Global.SORT_ORDER, "asc");
        }
        return  map;
    }
    public  static Map<String,Object> getParameters(HttpServletRequest request){
        return  getParameters(request,false);
    }
    public  static  String   getClientIp(HttpServletRequest request){
        String xff = request.getHeader("x-forwarded-for");
        if (xff == null) {
            return request.getRemoteAddr();
        }
        return xff;
    }


    public  static  String getIpAddrByRequest(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    public  static  String getRequestUrl(HttpServletRequest request){
        return request.getRequestURI().toString();
    }
    public  static  HttpServletRequest getCurrentRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public  static  Map<String,Object> getBody(HttpServletRequest request){
        String body=null;
        StringBuilder stringBuilder=new StringBuilder();
        BufferedReader bufferedReader=null;

        try {
            InputStream   inputStream = request.getInputStream();
            if (inputStream!=null){
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            char[] charBuffer=new char[128];
            int bytesRead=-1;
            while((bytesRead=bufferedReader.read(charBuffer))>0){
                stringBuilder.append(charBuffer,0,bytesRead);
            }
            }else {
                stringBuilder.append(""),
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       body=stringBuilder.toString();
        JSONObject jsonObject=new JSONObject(body);
        Map<String,Object> parames=new HashMap<>();
        Iterator<String> keys=jsonObject.keys();
        String key;
        while(keys.hasNext()){
            key=keys.next();
            parames.put(key,jsonObject.get(key));
        }
    }


}
