package com.linjun.api;

import com.linjun.annotation.LoginUser;
import com.linjun.entity.SignDetailEntity;
import com.linjun.entity.SignEntity;
import com.linjun.entity.UserEntity;
import com.linjun.service.ApiSignDetailService;
import com.linjun.service.ApiSignService;
import com.linjun.service.SysConfigService;
import com.linjun.util.ApiBaseAction;
import com.linjun.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author 林俊
 * @create 2018/3/28.
 * @desc
 **/
@Api(value = "签到接口")
@RestController
@RequestMapping(value = "/api/sign/")
public class ApiSignContrller extends ApiBaseAction {
    @Autowired
    private ApiSignService apiSignService;
    @Autowired
    private ApiSignDetailService apiSignDetailService;
    @Autowired
    private SysConfigService sysConfigService;

    @ApiOperation(value = "签到")
    @PostMapping(value = "sign")
    public JsonResult sign(@LoginUser UserEntity userEntity){
        Map param = new HashMap();
         param.put("userId",this.getUserId());
        int result=apiSignService.queryTotal(param);
        String temp=sysConfigService.getValue("signrate",null);
        String signvalue=sysConfigService.getValue("signvalue",null);
        if (result==1&&result>0){
            List<SignEntity> signEntities=apiSignService.queryList(param);
            long awardSum= signEntities.get(0).getAwardSum();
            long singinSum=signEntities.get(0).getSinginSum();
            long monSiginSum=signEntities.get(0).getMonSiginSum();
            Date date=signEntities.get(0).getEndsignTime();
            Calendar c=Calendar.getInstance();
            c.setTime(date);
            int year1=c.get(Calendar.YEAR);
            int month1=c.get(Calendar.MONTH)+1;
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH )+1;
      if (year==year1&month==month1){
         monSiginSum=monSiginSum+1;
      }
            if (singinSum>1){
            awardSum=awardSum+Math.multiplyExact(singinSum, Long.parseLong(temp));
           }else {
             awardSum=awardSum+Long.parseLong(signvalue);
           }
            SignEntity signEntity=new SignEntity();
            signEntity.setId(signEntities.get(0).getId());
            signEntity.setAwardSum(awardSum);
            signEntity.setUserId(this.getUserId());
            signEntity.setSinginSum(++singinSum);
            signEntity.setMonSiginSum(monSiginSum);
            signEntity.setEndsignTime(new Date());
            apiSignService.update(signEntity);
            SignDetailEntity signDetailEntity=new SignDetailEntity();
            signDetailEntity.setCreateTime(new Date());
            signDetailEntity.setSignparise(Math.multiplyExact(singinSum, Long.parseLong(temp)));
            signDetailEntity.setUserId(this.getUserId());
            apiSignDetailService.update(signDetailEntity);
        }else {

            List<SignEntity> signEntities=apiSignService.queryList(param);
            long awardSum= signEntities.get(0).getAwardSum();
            long singinSum=signEntities.get(0).getSinginSum();
            long monSiginSum=signEntities.get(0).getMonSiginSum();
            Date date=signEntities.get(0).getEndsignTime();
            Calendar c=Calendar.getInstance();
            c.setTime(date);
            int year1=c.get(Calendar.YEAR);
            int month1=c.get(Calendar.MONTH)+1;
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH )+1;
            if (year==year1&month==month1){
                monSiginSum=monSiginSum+1;
            }
            if (singinSum>1){
                awardSum=awardSum+Math.multiplyExact(singinSum, Long.parseLong(temp));
            }else {
                awardSum=awardSum+Long.parseLong(signvalue);
            }
            SignEntity signEntity=new SignEntity();
            signEntity.setAwardSum(awardSum);
            signEntity.setUserId(this.getUserId());
            signEntity.setSinginSum(++singinSum);
            signEntity.setMonSiginSum(monSiginSum);
            signEntity.setEndsignTime(new Date());
            apiSignService.update(signEntity);
            SignDetailEntity signDetailEntity=new SignDetailEntity();
            signDetailEntity.setCreateTime(new Date());
            signDetailEntity.setSignparise(Math.multiplyExact(singinSum, Long.parseLong(temp)));
            signDetailEntity.setUserId(this.getUserId());
            apiSignDetailService.update(signDetailEntity);
        }
       return
    }

}
