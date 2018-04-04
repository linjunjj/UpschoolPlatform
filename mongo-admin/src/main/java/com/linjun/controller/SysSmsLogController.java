package com.linjun.controller;

import com.alibaba.fastjson.JSON;
import com.linjun.entity.SmsConfig;
import com.linjun.entity.SysSmsLogEntity;
import com.linjun.service.SysConfigService;
import com.linjun.service.SysSmsLogService;
import com.linjun.utils.ConfigConstant;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/sys/smslog")
public class SysSmsLogController {
    @Autowired
    private SysSmsLogService smsLogService;
    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = ConfigConstant.SMS_CONFIG_KEY;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:smslog:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SysSmsLogEntity> smsLogList = smsLogService.queryList(query);
        int total = smsLogService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(smsLogList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:smslog:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") String id) {
        SysSmsLogEntity smsLog = smsLogService.queryObject(id);

        return JsonResult.ok().put("smsLog", smsLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:smslog:save")
    @ResponseBody
    public JsonResult save(@RequestBody SysSmsLogEntity smsLog) {
        smsLogService.save(smsLog);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:smslog:update")
    @ResponseBody
    public JsonResult update(@RequestBody SysSmsLogEntity smsLog) {
        smsLogService.update(smsLog);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:smslog:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody String[] ids) {
        smsLogService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<SysSmsLogEntity> list = smsLogService.queryList(params);

        return JsonResult.ok().put("list", list);
    }

    /**
     * 短信配置信息
     */
    @RequestMapping("/config")
    public JsonResult config() {
        SmsConfig config = sysConfigService.getConfigObject(KEY, SmsConfig.class);

        return JsonResult.ok().put("config", config);
    }

    /**
     * 保存短信配置信息
     */
    @RequestMapping("/saveConfig")
    public JsonResult saveConfig(@RequestBody SmsConfig config) {
        sysConfigService.updateValueByKey(KEY, JSON.toJSONString(config));
        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/sendSms")
    @ResponseBody
    public JsonResult sendSms(@RequestBody SysSmsLogEntity smsLog) {
        SysSmsLogEntity sysSmsLogEntity = smsLogService.sendSms(smsLog);
        return JsonResult.ok().put("result", sysSmsLogEntity);
    }
}
