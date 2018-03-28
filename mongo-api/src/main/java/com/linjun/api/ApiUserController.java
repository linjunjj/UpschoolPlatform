package com.linjun.api;

import com.alibaba.fastjson.JSONObject;
import com.linjun.annotation.IgnoreAuth;
import com.linjun.annotation.LoginUser;
import com.linjun.entity.SmsLogVo;
import com.linjun.entity.UserEntity;
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
    private ApiUserService userService;


    @ApiOperation(value = "获取用户的基本信息")
    @IgnoreAuth
    @RequestMapping("info")
    public JsonResult info(@LoginUser UserEntity loginUser, String mobile) {
        Map param = new HashMap();
        param.put("mobile", mobile);
        UserEntity user = userService.queryByMobile(mobile);
        user.setPassword("");
        return JsonResult.ok(user);
    }

    @ApiOperation(value = "保存用户头像")
    @PostMapping("saveAvatar")
    public  JsonResult saveAuatar(@LoginUser UserEntity userEntity,String avatar){
         UserEntity user=new UserEntity();
         user.setUserId(userEntity.getUserId());
         user.setAvatar(avatar);
        userService.update(user);
        return JsonResult.ok();
    }
   @ApiOperation(value = "发送短信")
    @IgnoreAuth
    @PostMapping(value = "smscode")
   public JsonResult smscode(@LoginUser UserEntity userEntity){
       JSONObject jsonParams = getJsonRequest();
       String phone = jsonParams.getString("phone");
       // 一分钟之内不能重复发送短信
       SmsLogVo smsLogVo = userService.querySmsCodeByUserId(userEntity.getUserId());
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
           smsLogVo.setUser_id(userEntity.getUserId());
           smsLogVo.setPhone(phone);
           smsLogVo.setSms_code(sms_code);
           smsLogVo.setSms_text(msgContent);
           userService.saveSmsCodeLog(smsLogVo);
           return JsonResult.error();

   }
    }

    @ApiOperation(value = "获取当前会员等级")
    @RequestMapping("getUserLevel")
    public JsonResult getUserLevel(@LoginUser UserEntity loginUser) {
        String userLevel = userService.getUserLevel(loginUser);
        return JsonResult.ok(userLevel);
    }

    @ApiOperation(value = "更新个人信息")
    @PutMapping(value = "updateinfo")
    public  JsonResult updateinfo(@LoginUser UserEntity userEntity){
        JSONObject jsonObject=this.getJsonRequest();
        UserEntity userEntity1=new UserEntity();
        if (jsonObject!=null){
            userEntity1.setUserId(userEntity.getUserId());
            userEntity1.setAvatar(jsonObject.getString("avatar"));
            userEntity1.setBirthday(jsonObject.getDate("birthday"));
            userEntity1.setGender(jsonObject.getString("gender"));
            userEntity1.setMajor(jsonObject.getString("major"));
            userEntity1.setNickname(jsonObject.getString("naickname"));
            userEntity1.setSchool(jsonObject.getString("school"));
            userEntity1.setMobile(jsonObject.getString("mobile"));
          userService.update(userEntity1);
        }

       return JsonResult.ok();
    }





}
