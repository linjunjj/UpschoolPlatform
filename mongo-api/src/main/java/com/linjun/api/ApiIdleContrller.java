package com.linjun.api;

import com.linjun.annotation.IgnoreAuth;
import com.linjun.entity.AdVo;
import com.linjun.entity.IdleCategroyVo;
import com.linjun.service.*;
import com.linjun.util.ApiBaseAction;
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
 * @create 2018/10/4.
 * @desc
 **/
@Api(value = "二手交易")
@RestController
@RequestMapping("/api/idle/")
public class ApiIdleContrller extends ApiBaseAction {
    @Autowired
    private ApiAdService apiAdService;
    @Autowired
    private ApiIdleService apiIdleService;
    @Autowired
    private ApiIdleCategoryService apiIdleCategoryService;
    @Autowired
    private ApiIdleImageService apiIdleImageService;
    @Autowired
    private ApiIdleMessageService apiIdleMessageService;
    /*
     * App首页首页数据
     * */
    @IgnoreAuth
    @RequestMapping("index")
    private JsonResult index(){
        Map<String, Object> resultObj = new HashMap();
        Map param = new HashMap();
        param.put("ad_position_id", 1);
        List<AdVo> banner=apiAdService.queryList(param);
        resultObj.put("banner",banner);
        param=new HashMap();
        List<IdleCategroyVo> idleCategroyVos=apiIdleCategoryService.queryList(param);
        resultObj.put("categroy",idleCategroyVos);
        param=new HashMap();
        param.put("",)




    }







}
