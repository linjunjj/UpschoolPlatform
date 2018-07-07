package com.linjun.api;

import com.linjun.annotation.IgnoreAuth;
import com.linjun.entity.AdVo;
import com.linjun.entity.ChannelVo;
import com.linjun.service.ApiAdService;
import com.linjun.service.ApiChannelService;
import com.linjun.utils.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/7/7.
 * @desc
 **/
@Api(value = "首页数据接口")
@RestController
@RequestMapping("/api/index/")
public class ApiIndexController {
  @Autowired
    private ApiAdService apiAdService;
  @Autowired
    private ApiChannelService apiChannelService;

    /*
    * App首页首页数据
    * */
    @IgnoreAuth
    @RequestMapping("index")
    private JsonResult index(){
        Map<String,Object> resultObj=new HashMap<>();
        Map param = new HashMap();
        param.put("ad_position_id", 1);
        List<AdVo> banner = apiAdService.queryList(param);
        resultObj.put("banner", banner);
        param = new HashMap();
        param.put("sidx", "sort_order ");
        param.put("order", "asc ");
        List<ChannelVo> channel = apiChannelService.queryList(param);
        resultObj.put("channel", channel);
       return JsonResult.ok(resultObj);
    }


}
