package com.linjun.api;

import com.linjun.annotation.LoginUser;
import com.linjun.entity.SignDetailVo;
import com.linjun.entity.SignVo;
import com.linjun.entity.UserVo;
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
@RequestMapping("/api/sign/")
public class ApiSignContrller extends ApiBaseAction {
    @Autowired
    private ApiSignService apiSignService;
    @Autowired
    private ApiSignDetailService apiSignDetailService;
    @Autowired
    private SysConfigService sysConfigService;

    @ApiOperation(value = "签到")
    @PostMapping(value = "sign")
    public JsonResult sign(@LoginUser UserVo UserVo){
        Map param = new HashMap();
         param.put("userId",this.getUserId());
        int result=apiSignService.queryTotal(param);
        String temp=sysConfigService.getValue("signrate",null);
        String signvalue=sysConfigService.getValue("signvalue",null);
        Map<String, Object> resultObj = new HashMap();
        if (result==1&&result>0){
            List<SignVo> signEntities=apiSignService.queryList(param);
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
            SignVo signVo =new SignVo();
            signVo.setId(signEntities.get(0).getId());
            signVo.setAwardSum(awardSum);
            signVo.setUserId(this.getUserId());
            signVo.setSinginSum(++singinSum);
            signVo.setMonSiginSum(monSiginSum);
            signVo.setEndsignTime(new Date());
            apiSignService.update(signVo);
            SignDetailVo signDetailVo =new SignDetailVo();
            signDetailVo.setCreateTime(new Date());
            signDetailVo.setSignparise(Math.multiplyExact(singinSum, Long.parseLong(temp)));
            signDetailVo.setUserId(this.getUserId());
            apiSignDetailService.update(signDetailVo);
        }else {

            List<SignVo> signEntities=apiSignService.queryList(param);
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
            SignVo signVo =new SignVo();
            signVo.setAwardSum(awardSum);
            signVo.setUserId(this.getUserId());
            signVo.setSinginSum(++singinSum);
            signVo.setMonSiginSum(monSiginSum);
            signVo.setEndsignTime(new Date());
            apiSignService.update(signVo);
            SignDetailVo signDetailVo =new SignDetailVo();
            signDetailVo.setCreateTime(new Date());
            signDetailVo.setSignparise(Math.multiplyExact(singinSum, Long.parseLong(temp)));
            signDetailVo.setUserId(this.getUserId());
            apiSignDetailService.update(signDetailVo);
        }
           List<SignVo> signEntities=apiSignService.queryList(param);
           List<SignDetailVo> signDetailEntities=apiSignDetailService.queryList(param);
        resultObj.put("id",signEntities.get(0).getId());
        resultObj.put("awardSum",signEntities.get(0).getAwardSum());
        resultObj.put("endsignTime",signEntities.get(0).getEndsignTime());
        resultObj.put("signDetail",signDetailEntities);

       return JsonResult.ok(resultObj);
    }

}
