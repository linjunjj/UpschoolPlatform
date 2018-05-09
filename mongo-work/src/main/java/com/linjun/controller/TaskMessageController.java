package com.linjun.controller;

import com.linjun.entity.TaskMessageEntity;
import com.linjun.service.TaskMessageService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/5/9.
 * @desc
 **/
@RestController
@RequestMapping("taskmessage")
public class TaskMessageController {
    @Autowired
    private TaskMessageService taskMessageService;
    @RequestMapping("/list")
    @RequiresPermissions("taskmessage:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<TaskMessageEntity> idleMessageEntities = taskMessageService.queryList(query);
        int total = taskMessageService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(idleMessageEntities, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("taskmessage:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        TaskMessageEntity taskMessageEntity = taskMessageService.queryObject(id);

        return JsonResult.ok().put("taskMessage", taskMessageEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("taskmessage:save")
    @ResponseBody
    public JsonResult save(@RequestBody TaskMessageEntity idleMessageEntity) {
        taskMessageService.save(idleMessageEntity);

        return JsonResult.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("taskmessage:update")
    @ResponseBody
    public JsonResult update(@RequestBody TaskMessageEntity taskMessageEntity) {
        taskMessageService.update(taskMessageEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("taskmessage:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        taskMessageService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<TaskMessageEntity> list = taskMessageService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
