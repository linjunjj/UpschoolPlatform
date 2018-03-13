package com.linjun.controller;

import com.linjun.entity.ScheduleJobLogEntity;
import com.linjun.service.ScheduleJobLogService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageBean;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
@RestController
@RequestMapping("sys/scheduleLog")
public class ScheduleJobLogController {
    @Autowired
    private ScheduleJobLogService scheduleJobLogService;
    @RequestMapping("/list")
    @RequiresPermissions("sys:schedule:log")
    public JsonResult list(@RequestParam Map<String,Object> params){
        Query query=new Query(params);
        List<ScheduleJobLogEntity>  jobLogEntityList=scheduleJobLogService.queryList(query);
        int total=scheduleJobLogService.queryTotal(query);
        PageBean pageBean =new PageBean(jobLogEntityList,total,query.getLimit(),query.getPage());
        return JsonResult.ok().put("page", pageBean);
    }
//    定时任务日志
    @RequestMapping("/info/{logId}")
    public JsonResult info (@PathVariable("logId") Long logId){
        ScheduleJobLogEntity log=scheduleJobLogService.queryObject(logId);
        return JsonResult.ok().put("log",log);
    }

}
