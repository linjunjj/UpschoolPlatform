package com.linjun.xss;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 林俊
 * @create 2018/3/9.
 * @desc
 **/
public class XssFilter implements Filter {
    private  String  excludePages;
    private String[] excludePageArray;

    @Override
    public void init(FilterConfig filterConfig) {
        excludePages=filterConfig.getInitParameter("excludedPages");
        if (StringUtils.isNotEmpty(excludePages)){
            excludePageArray=excludePages.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) servletRequest);
          boolean isExcludedPage=false;
        for (String page:
             excludePageArray) {
            if (((HttpServletRequest) servletRequest).getServletPath().equals(page)){
                isExcludedPage=true;
                break;
            }
        }
        if (isExcludedPage){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            filterChain.doFilter(xssRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
