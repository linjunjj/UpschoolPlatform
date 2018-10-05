package com.linjun.api;

import com.linjun.annotation.IgnoreAuth;
import com.linjun.entity.AdVo;
import com.linjun.entity.TaskLabelVo;
import com.linjun.entity.TaskVo;
import com.linjun.service.*;
import com.linjun.util.ApiBaseAction;
import io.swagger.annotations.Api;
import javafx.concurrent.Task;
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
@Api(value = "任务分享")
@RestController
@RequestMapping("/api/rent/")
public class ApiTaskController extends ApiBaseAction {
    @Autowired
    private ApiAdService apiAdService;
    @Autowired
    private ApiTaskImageService apiTaskImageService;
    @Autowired
    private ApiTaskMessageService apiTaskMessageService;
    @Autowired
    private ApiTaskService apiTaskService;
    @Autowired
    private ApiTaskLabelService apiTaskLabelService;
    /*
     *  租房首页数据
     * */
    @IgnoreAuth
    @RequestMapping("index")
    public  Object index(){
        Map<String, Object> resultObj = new HashMap();
        Map param = new HashMap();
        param.put("ad_position_id", 4);
        List<AdVo> banner=apiAdService.queryList(param);
        resultObj.put("banner",banner);
        param=new HashMap();
        param.put("sidx","sort_order");
        param.put("order","asc");
        List<TaskLabelVo> rentCategoryVoList=apiTaskLabelService.queryList(param);
        resultObj.put("categroy",rentCategoryVoList);
        param=new HashMap();
        param.put("sidx","create_time");
        param.put("order","desc");
        param.put("offset",0);
        param.put("limit",11);
        List<TaskVo> idleVoList=apiTaskService.queryList(param);
        resultObj.put("newRent",idleVoList);
        return  toResponsSuccess(resultObj);

    }





}
