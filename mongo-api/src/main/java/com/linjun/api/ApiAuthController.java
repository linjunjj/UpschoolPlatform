package com.linjun.api;

import com.linjun.service.ApiUserService;
import com.linjun.service.TokenService;
import com.linjun.util.ApiBaseAction;
import com.linjun.utils.JsonResult;
import com.linjun.validator.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/27.
 * @desc
 **/
@Api(value = "授权登接口")
@RestController
@RequestMapping("/api/auth/")
public class ApiAuthController extends ApiBaseAction {
    private Logger logger = Logger.getLogger(getClass());
    @Autowired
    private ApiUserService userService;
    @Autowired
    private TokenService tokenService;
   @ApiOperation(value = "login")
    public JsonResult login(String mobile,String passworld){
       Assert.isBlank(mobile,"手机号码不能为空");
       long userId=userService.login(mobile,passworld);
       Map<String,Object> map=tokenService.createToken(userId);
       return JsonResult.ok(map);
   }



}
