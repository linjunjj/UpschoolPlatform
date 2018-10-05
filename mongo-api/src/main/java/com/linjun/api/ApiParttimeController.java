package com.linjun.api;

import com.linjun.annotation.IgnoreAuth;
import com.linjun.entity.AdVo;
import com.linjun.entity.PartTimeCategoryVo;
import com.linjun.entity.PartTimeVo;
import com.linjun.service.*;
import com.linjun.util.ApiBaseAction;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/10/5.
 * @desc
 **/
@Api(value = "兼职")
@RestController
@RequestMapping("/api/parttime/")
public class ApiParttimeController extends ApiBaseAction {
    @Autowired
    private ApiAdService apiAdService;
    @Autowired
    private ApiPartTimeApplyVolumService apiPartTimeApplyVolumService;
    @Autowired
    private ApiPartTimeService apiPartTimeService;
    @Autowired
    private ApiPartTimeCategoryService apiPartTimeCategoryService;
    @Autowired
    private ApiPartTimeImageService apiPartTimeImageService;
    /*
     *  兼职首页数据
     * */
    @IgnoreAuth
    @RequestMapping("index")
    public  Object index(){
        Map<String, Object> resultObj = new HashMap();
        Map param = new HashMap();
        param.put("ad_position_id", 5);
        List<AdVo> banner=apiAdService.queryList(param);
        resultObj.put("banner",banner);
        param=new HashMap();
        param.put("sidx","sort_order");
        param.put("order","asc");
        List<PartTimeCategoryVo> rentCategoryVoList=apiPartTimeCategoryService.queryList(param);
        resultObj.put("categroy",rentCategoryVoList);
        param=new HashMap();
        param.put("sidx","create_time");
        param.put("order","desc");
        param.put("offset",0);
        param.put("limit",11);
        List<PartTimeVo> idleVoList=apiPartTimeService.queryList(param);
        resultObj.put("newParttime",idleVoList);
        return  toResponsSuccess(resultObj);

    }





}
