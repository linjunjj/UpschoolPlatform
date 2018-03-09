package com.linjun.utils;


import javafx.beans.binding.ObjectExpression;
import org.apache.commons.collections.iterators.EmptyListIterator;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import sun.invoke.empty.Empty;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 林俊
 * @create 2018/3/9.
 * @desc
 **/
public class HttpUtil {
    private static final Logger logger = org.apache.log4j.Logger.getLogger(HttpUtil.class);
    public static final String URL_PARAM_DECODECHARSET_UTF8 = "UTF-8";

    private static final String URL_PARAM_CONNECT_FLAG = "&";

    private static final String EMPTY = "";

    private static MultiThreadedHttpConnectionManager connectionManager = null;

    private static int connectionTimeOut = 25000;

    private static int socketTimeOut = 25000;

    private static int maxConnectionPerHost = 20;

    private static int maxTotalConnections = 20;

    private static HttpClient client;
    // 当前登录的人
    static Cookie[] cookies = null;
    // 登录URL
    static String loginURL = "/admin/login.do";
    // 登录账户
    static String loginUserName = "admin";
    static String loginPassword = "admin";
    static {
        connectionManager=new MultiThreadedHttpConnectionManager();
        connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
        connectionManager.getParams().setSoTimeout(socketTimeOut);
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
        connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);
        client=new HttpClient(connectionManager);

    }
    public  static  String URLPost(String url, Map<String,Object>  params,String enc){
        String response=EMPTY;
        PostMethod postMethod=null;
        try {
        postMethod=new PostMethod(url);
        postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
        Set<String> keySet=params.keySet();
        for (String key:
             keySet) {
            Object value=params.get(key);
            postMethod.addParameter(key,String.valueOf(value));
        }

            int statusCode=client.executeMethod(postMethod);
            if (statusCode== HttpStatus.SC_OK){
                response=postMethod.getResponseBodyAsString();
            }else {

                logger.error("响应状态码 = " + postMethod.getStatusCode());
            }
        }catch (HttpException e){
            logger.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("发生网络异常", e);
            e.printStackTrace();
        }finally {
            if (postMethod!=null){
                postMethod.releaseConnection();
                postMethod=null;
            }
        }
        return  response;
    }
    public  static  String URLGet(String url,Map<String,String> params,String enc){
        String response=EMPTY;
        GetMethod getMethod=null;
        StringBuffer stringBuffer=new StringBuffer(EMPTY);
        if (stringBuffer.indexOf("?")==-1){
            stringBuffer.append(url).append("?").append(getUrl(params,enc));
        }else {
            stringBuffer.append("&").append(getUrl(params,enc));
        }
        logger.debug("GET请求URL = \n" + stringBuffer.toString());
        try {
            getMethod = new GetMethod(stringBuffer.toString());
            getMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            //执行getMethod
            int statusCode = client.executeMethod(getMethod);
            if (statusCode == HttpStatus.SC_OK) {
                response = getMethod.getResponseBodyAsString();
            } else {
                logger.debug("响应状态码 = " + getMethod.getStatusCode());
            }
        } catch (HttpException e) {
            logger.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("发生网络异常", e);
            e.printStackTrace();
        } finally {
            if (getMethod != null) {
                getMethod.releaseConnection();
                getMethod = null;
            }
        }

        return response;
    }

  private  static  String getUrl(Map<String,String> map,String valueEnc){
        if (map==null||map.keySet().size()==0){
            return null;
        }
        StringBuffer url=new StringBuffer();
        Set<String> keys=map.keySet();
        for (Iterator<String> it=keys.iterator();it.hasNext();){
            String key=it.next();
            if (map.containsKey(key)){
                String val=map.get(key);
                String str=val!=null?val:EMPTY;
                    try {
                        str= URLEncoder.encode(str,valueEnc);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    url.append(key).append("=").append(str).append(URL_PARAM_CONNECT_FLAG);

            }
        }
        String strURL=EMPTY;
        strURL=url.toString();
        if (URL_PARAM_CONNECT_FLAG.equals(EMPTY+strURL.charAt(strURL.length()-1))){
            strURL=strURL.substring(0,strURL.length()-1);
        }
        return strURL;
  }

  public  static  String URLPost(String url, Map<String,Object> params,String enc,boolean session){
        String respons= EMPTY;
        PostMethod postMethod=null;
        if (!session){
            return URLPost(url,params,enc);
        }
      try {
       postMethod=new PostMethod();
        postMethod.setRequestHeader("Content-Type","applicatiuon/x-www-from-urlencoded;charset="+enc);
        Set<String> keySet=params.keySet();
      for (String key:
           keySet) {
          Object value=params.get(key);
          postMethod.addParameter(key,String.valueOf(value));
      }
      if (cookies!=null){
          client.getState().addCookies(cookies);
      }else {
          getAuthCookie(url,enc);
          client.getState().addCookies(cookies);
      }

          int statusCode=client.executeMethod(postMethod);
           if (statusCode==HttpStatus.SC_OK){
               respons=postMethod.getResponseBodyAsString();
           }else {
               logger.error("相应状态码="+postMethod.getStatusCode());
           }
      } catch (HttpException e) {
          logger.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
          e.printStackTrace();
        }catch (IOException e) {
          e.printStackTrace();
      }finally {
            if (postMethod!=null){
                postMethod.releaseConnection();
                postMethod=null;
            }
      }
      return  respons;
  }

public  static  void  getAuthCookie(String url,String enc){
        PostMethod postMethod =null;
    try {
        Object[] ipPort = getIpPortFormURL(url);
        String ip = (String) ipPort[0];
        int port = (Integer) ipPort[1];
        String logUrl = "http://" + ip + ":" + port + loginURL;
        postMethod = new PostMethod(logUrl);
        postMethod.addParameter("username", loginUserName);
        postMethod.addParameter("password", loginPassword);
        postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
        //执行postMethod
        int statusCode = client.executeMethod(postMethod);
        // 查看 cookie 信息
        CookieSpec cookiespec = CookiePolicy.getDefaultSpec();
        cookies = cookiespec.match(ip, port, "/", false, client.getState().getCookies());
        logger.error("响应状态码 = " + postMethod.getStatusCode());
    } catch (HttpException e) {
        logger.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
        e.printStackTrace();
    } catch (IOException e) {
        logger.error("发生网络异常", e);
        e.printStackTrace();
    } finally {
        if (postMethod != null) {
            postMethod.releaseConnection();
            postMethod = null;
        }
    }
}
    public static Object[] getIpPortFormURL(String URL) {
        Object[] ip_port = new Object[2];
        try {
            java.net.URL url = new java.net.URL(URL);
            ip_port[0] = url.getHost();
            ip_port[1] = url.getPort() != -1 ? url.getPort() : 80;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ip_port;
    }

    public static void setLoginPassword(String loginPassword) {
        HttpUtil.loginPassword = loginPassword;
    }

    public static void setLoginUserName(String loginUserName) {
        HttpUtil.loginUserName = loginUserName;
    }

    public static void setLoginURL(String loginURL) {
        HttpUtil.loginURL = loginURL;
    }

    public static void main(String[] args) throws MalformedURLException {
        java.net.URL url = new java.net.URL("http://blog.csdn.net/zhujianlin1990");
        System.out.println(url.getHost());
        System.out.println(url.getPort());
    }


}
