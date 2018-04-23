package com.linjun.controller;

import com.linjun.entity.TaskEntity;
import com.linjun.service.TaskService;
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
 * @create 2018/4/23.
 * @desc
 **/
@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("task:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<TaskEntity> taskEntityList = taskService.queryList(query);
        int total = taskService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(taskEntityList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("idle:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        TaskEntity taskEntity = taskService.queryObject(id);

        return JsonResult.ok().put("task", taskEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("idle:save")
    @ResponseBody
    public JsonResult save(@RequestBody TaskEntity taskEntity) {
        taskService.save(taskEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("idle:update")
    @ResponseBody
    public JsonResult update(@RequestBody TaskEntity taskEntity) {
        taskService.update(taskEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("idle:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        taskService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<TaskEntity> list = taskService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
