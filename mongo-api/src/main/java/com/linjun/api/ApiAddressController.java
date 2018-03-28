package com.linjun.api;

import com.alibaba.fastjson.JSONObject;
import com.linjun.annotation.LoginUser;
import com.linjun.dao.ApiAddressMangerMapper;
import com.linjun.entity.AddressManger;
import com.linjun.entity.ShippingEntity;
import com.linjun.entity.UserEntity;
import com.linjun.service.ApiShippingService;
import com.linjun.util.ApiBaseAction;
import com.linjun.util.ApiPageUtils;
import com.linjun.utils.JsonResult;
import com.linjun.utils.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private ApiShippingService apiShippingService;

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
      JSONObject jsonObject=this.getJsonRequest();
      AddressManger addressManger=new AddressManger();
      if (jsonObject!=null){
          addressManger.setId(jsonObject.getLong("id"));
          addressManger.setCity_name(jsonObject.getString("city_name"));
          addressManger.setCountry_name(jsonObject.getString("country_name"));
          addressManger.setDetail_info(jsonObject.getString("detail_info"));
          addressManger.setIs_default(jsonObject.getByte("is_default"));
          addressManger.setNational_code(jsonObject.getString("national_code"));
          addressManger.setPostal_code(jsonObject.getString("postal_code"));
          addressManger.setProvince_name(jsonObject.getString("province_name"));
          addressManger.setTel_number(jsonObject.getString("tel_number"));
          addressManger.setUser_name(jsonObject.getString("user_name"));
      }
      if (addressManger.getId()==null||addressManger.getId()==0){
            addressManger.setId(null);
            addressService.save(addressManger);
      }else {
          addressService.update(addressManger);
      }
      return JsonResult.ok();
  }

   @ApiOperation(value = "删除指定收货地址")
    @DeleteMapping(value = "delete")
    public  JsonResult delete(){
         JSONObject jsonObject=this.getJsonRequest();
         addressService.delete(jsonObject.getLong("id"));
         return  JsonResult.ok();
   }
    @ApiOperation(value = "查看地址列表")
    @GetMapping(value = "getshippinglist")
    public  JsonResult getshippinglist(@RequestParam Map<String, Object> params){
        Query query=new Query(params);
        List<ShippingEntity> shippingEntityList=apiShippingService.queryList(query);
        int total=apiShippingService.queryTotal(query);
        ApiPageUtils pagerUtils=new ApiPageUtils(shippingEntityList,total,query.getLimit(),query.getPage());
        return JsonResult.ok(pagerUtils);
    }



}
