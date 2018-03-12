package aop;

import com.alibaba.fastjson.JSON;
import com.linjun.annotation.SysLog;
import com.linjun.entity.SysLogEntity;
import com.linjun.entity.SysUserEntity;
import com.linjun.service.SysLogService;
import com.linjun.utils.HttpContextUtils;
import com.linjun.utils.IPUtils;
import com.linjun.utils.ShiroUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/12.
 * @desc
 **/
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;
    @Pointcut("@annotation(com.linjun.annotation.SysLog)")
    public void logPointCut() {

    }
    @Before("logPointCut()")
    public  void  saveSysLog(JoinPoint joinPoint){
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        Method method=methodSignature.getMethod();
        SysLogEntity sysLogEntity=new SysLogEntity();
        SysLog sysLog=method.getAnnotation(SysLog.class);
        if (sysLog!=null){
            sysLogEntity.setOperation(sysLog.value());
        }
       String className=joinPoint.getTarget().getClass().getName();
        String methodName=methodSignature.getName();
        sysLogEntity.setMethod(className+"."+methodName+"()");
        Object[] args=joinPoint.getArgs();
        String params= JSON.toJSONString(args[0]);
        sysLogEntity.setParams(params);
        HttpServletRequest request= HttpContextUtils.getHttpServletRequest();
        sysLogEntity.setIp(IPUtils.getIpAddr(request));
        SysUserEntity sysUserEntity= ShiroUtils.getUserEntity();
       String username="";
       if ("login".equals(methodName)){
           username=params;
       }
       if (sysUserEntity!=null){
           username=ShiroUtils.getUserEntity().getUsername();
       }
       sysLogEntity.setUsername(username);
       sysLogEntity.setCreateDate(new Date());
       sysLogService.save(sysLogEntity);
    }

}
