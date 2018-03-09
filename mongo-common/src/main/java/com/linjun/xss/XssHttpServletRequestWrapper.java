package com.linjun.xss;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/9.
 * @desc
 **/
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    HttpServletRequest orgRequest;
    private  final  static  HTMLFilter htmlFilter=new HTMLFilter();
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        orgRequest=request;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
         if (!super.getHeader(HttpHeaders.CONTENT_TYPE).equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)){
             return super.getInputStream();
         }
            String json= IOUtils.toString(super.getInputStream(),"utf-8");
           if (StringUtils.isBlank(json)){
               return super.getInputStream();
           }
           json=xssEncode(json);
           final ByteArrayInputStream bis=new ByteArrayInputStream(json.getBytes("utf-8"));
            return new ServletInputStream() {
                @Override
                public boolean isFinished() {
                    return true;
                }

                @Override
                public boolean isReady() {
                    return true;
                }

                @Override
                public void setReadListener(ReadListener readListener) {

                }

                @Override
                public int read() throws IOException {
                    return bis.read();
                }
            };

    }

    @Override
    public String getParameter(String name) {
        String  value=super.getParameter(xssEncode(name));
        if (StringUtils.isNotBlank(value)){
            value=xssEncode(value);
        }
        return value;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String,String[]> map=new LinkedHashMap<>();
        Map<String,String[]> parameter=super.getParameterMap();
        for (String key:
             parameter.keySet()) {
               String[] values=parameter.get(key);
            for (int i = 0; i < values.length ; i++) {
                values[i]=xssEncode(values[i]);
            }
            map.put(key,values);
        }
        return map;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] parameter=super.getParameterValues(name);
        if (parameter==null||parameter.length==0){
            return null;
        }
        for (int i = 0; i < parameter.length; i++) {
            parameter[i]=xssEncode(parameter[i]);
        }

        return  parameter;
    }

    private  String xssEncode(String name){
        return  htmlFilter.filter(name);
     }

    public HttpServletRequest getOrgRequest() {
          return  orgRequest;
    }
    public   static  HttpServletRequest getOrgRequest(HttpServletRequest request){
        if (request instanceof  XssHttpServletRequestWrapper){
            return  ((XssHttpServletRequestWrapper) request).getOrgRequest();
        }
        return  request;
    }

}
