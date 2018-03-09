package com.linjun.utils;


import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import java.io.IOException;
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
        String re
    }




}
