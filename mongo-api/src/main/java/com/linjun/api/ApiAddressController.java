package com.linjun.api;

import com.linjun.annotation.LoginUser;
import com.linjun.dao.ApiAddressMangerMapper;
import com.linjun.entity.AddressManger;
import com.linjun.entity.UserEntity;
import com.linjun.util.ApiBaseAction;
import com.linjun.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/27.
 * @desc
 **/
@Api(value = "用户地址接口")
@RestController
@RequestMapping(value = "/api/address/")
public class ApiAddressController extends ApiBaseAction {
    @Autowired
    private ApiAddressMangerMapper addressService;
     @ApiOperation(value = "获取用户收货地址")
    @GetMapping(value = "list")
    public JsonResult list(@LoginUser UserEntity userEntity){
         Map map=new HashMap();
         map.put("userId",userEntity.getUserId());
         List<AddressManger> list=addressService.queryList(map);
         return JsonResult.ok(list);
     }
   @ApiOperation(value = "获取收货地址详情")
    @GetMapping(value = "detail")
    public JsonResult detail(@LoginUser UserEntity userEntity){
      AddressManger addressManger=addressService.queryObject(userEntity.getUserId());
      return  JsonResult.ok(addressManger);
   }
  @ApiOperation(value = "添加或者更新地址")
    @PostMapping(value = "saveOrUpdate")
    public  JsonResult saveOrUpdate(@LoginUser UserEntity userEntity){

  }


}
