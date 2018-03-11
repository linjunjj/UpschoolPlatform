package com.linjun.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author 林俊
 * @create 2018/3/11.
 * @desc
 **/
public class VelocityShiro {
    public  boolean hasPermission(String permission){
        Subject subject= SecurityUtils.getSubject();
        return  subject!=null&&subject.isPermitted(permission);
    }

}
