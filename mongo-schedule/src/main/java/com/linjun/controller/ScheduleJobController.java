package com.linjun.controller;

import com.linjun.annotation.SysLog;
import com.linjun.entity.ScheduleJobEntity;
import com.linjun.service.ScheduleJobService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageBean;
import com.linjun.utils.Query;
import com.linjun.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
@RestController
@RequestMapping("/sys/schedule")
public class ScheduleJobController {
    @Autowired
    private ScheduleJobService scheduleJobService;
    @RequestMapping("/list")
    @RequiresPermissions("sys:schedule:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ScheduleJobEntity> jobList = scheduleJobService.queryList(query);
        int total = scheduleJobService.queryTotal(query);

        PageBean pageUtil = new PageBean(jobList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 定时任务信息
     */
    @RequestMapping("/info/{jobId}")
    @RequiresPermissions("sys:schedule:info")
    public JsonResult info(@PathVariable("jobId") Long jobId) {
        ScheduleJobEntity schedule = scheduleJobService.queryObject(jobId);

        return JsonResult.ok().put("schedule", schedule);
    }

    /**
     * 保存定时任务
     */
    @SysLog("保存定时任务")
    @RequestMapping("/save")
    @RequiresPermissions("sys:schedule:save")
    public JsonResult save(@RequestBody ScheduleJobEntity scheduleJob) {
        ValidatorUtils.validateEntity(scheduleJob);

        scheduleJobService.save(scheduleJob);

        return JsonResult.ok();
    }

    /**
     * 修改定时任务
     */
    @SysLog("修改定时任务")
    @RequestMapping("/update")
    @RequiresPermissions("sys:schedule:update")
    public JsonResult update(@RequestBody ScheduleJobEntity scheduleJob) {
        ValidatorUtils.validateEntity(scheduleJob);

        scheduleJobService.update(scheduleJob);

        return JsonResult.ok();
    }

    /**
     * 删除定时任务
     */
    @SysLog("删除定时任务")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:schedule:delete")
    public JsonResult delete(@RequestBody Long[] jobIds) {
        scheduleJobService.deleteBatch(jobIds);

        return JsonResult.ok();
    }

    /**
     * 立即执行任务
     */
    @SysLog("立即执行任务")
    @RequestMapping("/run")
    @RequiresPermissions("sys:schedule:run")
    public JsonResult run(@RequestBody Long[] jobIds) {
        scheduleJobService.run(jobIds);

        return JsonResult.ok();
    }

    /**
     * 暂停定时任务
     */
    @SysLog("暂停定时任务")
    @RequestMapping("/pause")
    @RequiresPermissions("sys:schedule:pause")
    public JsonResult pause(@RequestBody Long[] jobIds) {
        scheduleJobService.pause(jobIds);

        return JsonResult.ok();
    }

    /**
     * 恢复定时任务
     */
    @SysLog("恢复定时任务")
    @RequestMapping("/resume")
    @RequiresPermissions("sys:schedule:resume")
    public JsonResult resume(@RequestBody Long[] jobIds) {
        scheduleJobService.resume(jobIds);

        return JsonResult.ok();
    }
}
