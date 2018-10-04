package com.linjun.api;

import com.alibaba.fastjson.JSONObject;
import com.linjun.annotation.IgnoreAuth;
import com.linjun.annotation.LoginUser;
import com.linjun.entity.SmsLogVo;
import com.linjun.entity.UserVo;
import com.linjun.service.ApiUserService;
import com.linjun.util.ApiBaseAction;
import com.linjun.utils.CharUtil;
import com.linjun.utils.JsonResult;
import com.linjun.utils.sms.SmsAlidayu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/27.
 * @desc
 **/
@Api(value = "用户个人信息接口")
@RestController
@RequestMapping("/api/user/")
public class ApiUserController extends ApiBaseAction {
    @Autowired
    private ApiUserService apiUserService;
    @ApiOperation(value = "获取用户的基本信息")
    @IgnoreAuth
    @RequestMapping("info")
    public JsonResult info(@LoginUser UserVo loginUser, String mobile) {
        Map param = new HashMap();
        param.put("mobile", mobile);
        UserVo user = apiUserService.queryByMobile(mobile);
        user.setPassword("");
        return JsonResult.ok(user);
    }

    @ApiOperation(value = "保存用户头像")
    @PostMapping("saveAvatar")
    public  JsonResult saveAuatar(@LoginUser UserVo UserVo,String avatar){
         UserVo user=new UserVo();
         user.setUserId(UserVo.getUserId());
         user.setAvatar(avatar);
        apiUserService.update(user);
        return JsonResult.ok();
    }
   @ApiOperation(value = "发送短信")
    @IgnoreAuth
    @PostMapping(value = "smscode")
   public JsonResult smscode(@LoginUser UserVo UserVo){
       JSONObject jsonParams = getJsonRequest();
       String phone = jsonParams.getString("phone");
       // 一分钟之内不能重复发送短信
       SmsLogVo smsLogVo = apiUserService.querySmsCodeByUserId(UserVo.getUserId());
       if (null != smsLogVo && (System.currentTimeMillis() / 1000 - smsLogVo.getLog_date()) < 1 * 60) {
           return JsonResult.ok();
       }
       //生成验证码
       String sms_code = CharUtil.getRandomNum(4);
       String smsTemplateCode = "SMS_94340007";
       String msgContent = "您的验证码是：" + sms_code + "，请在页面中提交验证码完成验证。";
       String param = "{\"code\":\"" + sms_code + "\"}";
       // 发送短信
//        String rpt = "0";
       String rpt = SmsAlidayu.sendTplShortMessage(param, phone, smsTemplateCode);
       if (rpt == null || rpt.equals("0") == false) {
           return JsonResult.error();
       } else {
           smsLogVo = new SmsLogVo();
           smsLogVo.setLog_date(System.currentTimeMillis() / 1000);
           smsLogVo.setUser_id(UserVo.getUserId());
           smsLogVo.setPhone(phone);
           smsLogVo.setSms_code(sms_code);
           smsLogVo.setSms_text(msgContent);
           apiUserService.saveSmsCodeLog(smsLogVo);
           return JsonResult.error();

   }
    }

    @ApiOperation(value = "获取当前会员等级")
    @RequestMapping("getUserLevel")
    public JsonResult getUserLevel(@LoginUser UserVo loginUser) {
        String userLevel = apiUserService.getUserLevel(loginUser);
        return JsonResult.ok(userLevel);
    }

    @ApiOperation(value = "更新个人信息")
    @PutMapping(value = "updateinfo")
    public  JsonResult updateinfo(@LoginUser UserVo UserVo){
        JSONObject jsonObject=this.getJsonRequest();
        UserVo UserVo1=new UserVo();
        if (jsonObject!=null){
            UserVo1.setUserId(UserVo.getUserId());
            UserVo1.setAvatar(jsonObject.getString("avatar"));
            UserVo1.setBirthday(jsonObject.getDate("birthday"));
            UserVo1.setGender(jsonObject.getString("gender"));
            UserVo1.setMajor(jsonObject.getString("major"));
            UserVo1.setNickname(jsonObject.getString("naickname"));
            UserVo1.setSchool(jsonObject.getString("school"));
            UserVo1.setMobile(jsonObject.getString("mobile"));
          apiUserService.update(UserVo1);
        }

       return JsonResult.ok();
    }





}
