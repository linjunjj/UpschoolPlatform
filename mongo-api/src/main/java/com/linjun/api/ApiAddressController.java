package com.linjun.api;

import com.alibaba.fastjson.JSONObject;
import com.linjun.annotation.LoginUser;
import com.linjun.entity.AddressMangerVo;
import com.linjun.entity.ShippingVo;
import com.linjun.entity.UserVo;
import com.linjun.service.ApiAddressMangerService;
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
    private ApiAddressMangerService addressService;
    @Autowired
    private ApiShippingService apiShippingService;

     @ApiOperation(value = "获取用户收货地址")
    @GetMapping(value = "list")
    public JsonResult list(@LoginUser UserVo UserVo){
         Map map=new HashMap();
         map.put("userId",UserVo.getUserId());
         List<AddressMangerVo> list=addressService.queryList(map);
         return JsonResult.ok(list);
     }
   @ApiOperation(value = "获取收货地址详情")
    @GetMapping(value = "detail")
    public JsonResult detail(@LoginUser UserVo UserVo){
      AddressMangerVo addressMangerVo =addressService.queryObject(UserVo.getUserId());
      return  JsonResult.ok(addressMangerVo);
   }
  @ApiOperation(value = "添加或者更新地址")
    @PostMapping(value = "saveOrUpdate")
    public  JsonResult saveOrUpdate(@LoginUser UserVo UserVo){
      JSONObject jsonObject=this.getJsonRequest();
      AddressMangerVo addressMangerVo =new AddressMangerVo();
      if (jsonObject!=null){
          addressMangerVo.setId(jsonObject.getLong("id"));
          addressMangerVo.setCity_name(jsonObject.getString("city_name"));
          addressMangerVo.setCountry_name(jsonObject.getString("country_name"));
          addressMangerVo.setDetail_info(jsonObject.getString("detail_info"));
          addressMangerVo.setIs_default(jsonObject.getByte("is_default"));
          addressMangerVo.setNational_code(jsonObject.getString("national_code"));
          addressMangerVo.setPostal_code(jsonObject.getString("postal_code"));
          addressMangerVo.setProvince_name(jsonObject.getString("province_name"));
          addressMangerVo.setTel_number(jsonObject.getString("tel_number"));
          addressMangerVo.setUser_name(jsonObject.getString("user_name"));
      }
      if (addressMangerVo.getId()==null|| addressMangerVo.getId()==0){
            addressMangerVo.setId(null);
            addressService.save(addressMangerVo);
      }else {
          addressService.update(addressMangerVo);
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
        List<ShippingVo> shippingVoList =apiShippingService.queryList(query);
        int total=apiShippingService.queryTotal(query);
        ApiPageUtils pagerUtils=new ApiPageUtils(shippingVoList,total,query.getLimit(),query.getPage());
        return JsonResult.ok(pagerUtils);
    }



}
