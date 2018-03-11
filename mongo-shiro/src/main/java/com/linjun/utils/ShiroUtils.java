package com.linjun.utils;


import com.linjun.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
public class ShiroUtils {
    public  static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }
    public  static Subject getSubject(){
        return  SecurityUtils.getSubject();
    }
    public  static SysUserEntity getUserEntity(){
        return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

}
