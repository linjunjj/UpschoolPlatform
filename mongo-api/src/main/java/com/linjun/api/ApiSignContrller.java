package com.linjun.api;

import com.linjun.annotation.LoginUser;
import com.linjun.entity.UserEntity;
import com.linjun.service.ApiSignDetailService;
import com.linjun.service.ApiSignService;
import com.linjun.util.ApiBaseAction;
import com.linjun.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @ApiOperation(value = "签到")
    @PostMapping(value = "sign")
    public JsonResult sign(@LoginUser UserEntity userEntity){
        Map param = new HashMap();
         param.put("userId",this.getUserId());
        int result=apiSignService.queryTotal(param);
        if (result==1&&result>0){

        }

    }

}
