package aop;

import com.linjun.annotation.DataFilter;
import com.linjun.entity.SysUserEntity;
import com.linjun.service.SysRoleDepService;
import com.linjun.utils.Constant;
import com.linjun.utils.RRException;
import com.linjun.utils.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/12.
 * @desc
 **/
@Aspect
@Component
public class DataFilterAspect {
    @Autowired
    private SysRoleDepService sysRoleDepService;
    @Pointcut("@annotation(com.linjun.annotation.DataFilter)")
    public void dataFilterCut() {
    }
 @Before("dataFilterCut()")
  public  void dataFilter(JoinPoint joinPoint) throws  Throwable{
        Object params=joinPoint.getArgs()[0];
        if (params!=null&& params instanceof Map){
            SysUserEntity userEntity= ShiroUtils.getUserEntity();
            if (userEntity.getUserId()!= Constant.SUPER_ADMIN){
                Map map= (Map) params;
                map.put("filterSql",);
            }
            return;
        }
        throw new RRException("数据接口其权限必须为毛类型，而且不能为null");
 }

 private  String getFilterSQL(SysUserEntity userEntity, JoinPoint joinpoint){
     MethodSignature signature = (MethodSignature) joinpoint.getSignature();
     DataFilter dataFilter = signature.getMethod().getAnnotation(DataFilter.class);
       String userAlias=dataFilter.userAlias();
       String deptAlias=dataFilter.deptAlias();
       StringBuilder stringBuilder=new StringBuilder();
       stringBuilder.append(" and ( ");
       if (StringUtils.isNotEmpty(deptAlias)||StringUtils.isNotBlank(userAlias)){
           if (StringUtils.isNotEmpty(deptAlias)){
               String alias=getAliasByUser(userEntity.getUserId());
               stringBuilder.append(deptAlias);
               stringBuilder.append(" in ");
               stringBuilder.append(" ( ");
               stringBuilder.append(alias);
               stringBuilder.append(" ) ");
               if (StringUtils.isNotBlank(userAlias)){
                   if (dataFilter.self()){
                       stringBuilder.append(" or ");
                   }else {
                       stringBuilder.append(" and ");
                   }
               }
           }
           if (StringUtils.isNotBlank(userAlias)){
               stringBuilder.append(userAlias);
               stringBuilder.append(" = ");
               stringBuilder.append(userEntity.getUserId());
               stringBuilder.append(" ");
           }

       }else {
           return "";
       }
       stringBuilder.append("  )");
       return  stringBuilder.toString();
 }

 private  String getAliasByUser(Long userId){
     List<Long> roleOrglist=sysRoleDepService.queryDeptIdListByUserId(userId);
     StringBuilder stringBuilder=new StringBuilder();
     String alias="";
     if (roleOrglist!=null&&!roleOrglist.isEmpty()){
         for (Long roleId:
              roleOrglist) {
              stringBuilder.append(",");
              stringBuilder.append("'");
              stringBuilder.append(roleId);
              stringBuilder.append("'");
         }
         alias=stringBuilder.toString().substring(1,stringBuilder.length());
     }
     return  alias;
 }

}
