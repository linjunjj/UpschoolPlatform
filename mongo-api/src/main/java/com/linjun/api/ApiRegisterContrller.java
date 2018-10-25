package com.linjun.api;

import com.linjun.annotation.IgnoreAuth;
import com.linjun.entity.UserVo;
import com.linjun.service.ApiUserService;
import com.linjun.utils.JsonResult;
import com.linjun.validator.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Api(value = "注册接口")
@RestController
@RequestMapping("/api/register/")
public class ApiRegisterContrller {
    @Autowired
    private ApiUserService userService;


    @ApiOperation(value = "根据手机号码注册")
    @IgnoreAuth
    @RequestMapping("registerbyTel")
    public JsonResult registerByTel(String mobile, String password) {
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");
         UserVo UserVo= userService.queryByMobile(mobile);
  if ( UserVo==null){
      userService.save(mobile, password);
      return JsonResult.ok();
  }else {
      return JsonResult.error(500,"用户已存ss在搜索，请尝试密码");
  }
    }

    @ApiOperation(value = "  代付   想 订单订单的的")


}
