package com.linjun.shiro;

import com.linjun.Global;
import com.linjun.dao.SysMenuDao;
import com.linjun.dao.SysUserDao;
import com.linjun.entity.SysMenuEntity;
import com.linjun.entity.SysUserEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author 林俊
 * @create 2018/3/11.
 * @desc
 **/
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUserEntity userEntity= (SysUserEntity) principalCollection.getPrimaryPrincipal();
        Long userid=userEntity.getUserId();
        List<String> permsList=null;
        if (userid==1){
            List<SysMenuEntity> menuEntityList=sysMenuDao.queryList(new HashMap<String,Object>());
            permsList=new ArrayList<>(menuEntityList.size());
            for (SysMenuEntity menu:
                 menuEntityList) {
                permsList.add(menu.getPerms());
            }
        }else {
            permsList=sysUserDao.queryAllPerms(userid);
        }
        Set<String> permsSet=new HashSet<>();
        for (String perms:
             permsList) {
            if (StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permsSet);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username= (String) authenticationToken.getPrincipal();
        String passworld=new String((char[])authenticationToken.getCredentials());
        SysUserEntity user=sysUserDao.queryByUserName(username);
        if (user==null){
            throw new UnknownAccountException("账号或者密码不正确");
        }
        if (!passworld.equals(user.getPassword())){
         throw new IncorrectCredentialsException("账号或者密码不正确");
        }
        if (user.getStatus()==0){
            throw new LockedAccountException("账号已被锁定，请联系管理员");
        }
        Subject subject = SecurityUtils.getSubject();
       Session session = subject.getSession(true);
        session.setAttribute(Global.CURRENT_USER, user);
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,passworld,getName());
        return info;
    }
}
