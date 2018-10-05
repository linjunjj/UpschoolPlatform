package com.linjun.api;

import com.linjun.annotation.IgnoreAuth;
import com.linjun.entity.AdVo;
import com.linjun.entity.IdleCategroyVo;
import com.linjun.entity.IdleVo;
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
     *  二手交易首页数据
     * */
    @IgnoreAuth
    @RequestMapping("index")
    private Object index(){
        Map<String, Object> resultObj = new HashMap();
        Map param = new HashMap();
        param.put("ad_position_id", 1);
        List<AdVo> banner=apiAdService.queryList(param);
        resultObj.put("banner",banner);
        param=new HashMap();
        param.put("sidx","sort_order");
        param.put("order","asc");
        List<IdleCategroyVo> idleCategroyVos=apiIdleCategoryService.queryList(param);
        resultObj.put("categroy",idleCategroyVos);
        param=new HashMap();
        param.put("sidx","create_time");
        param.put("order","desc");
        param.put("offset",0);
        param.put("limit",10);
        List<IdleVo> idleVoList=apiIdleService.queryList(param);
        resultObj.put("newIdle",idleVoList);
        return  toResponsSuccess(resultObj);
    }







}
