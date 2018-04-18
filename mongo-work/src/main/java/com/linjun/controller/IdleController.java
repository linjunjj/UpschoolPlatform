package com.linjun.controller;

import java.util.List;
import java.util.Map;

import com.linjun.entity.IdleEntity;
import com.linjun.service.IdleService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 闲置Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-04-18 21:29:57
 */
@RestController
@RequestMapping("idle")
public class IdleController {
    @Autowired
    private IdleService idleService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("idle:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<IdleEntity> idleList = idleService.queryList(query);
        int total = idleService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(idleList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("idle:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        IdleEntity idle = idleService.queryObject(id);

        return JsonResult.ok().put("idle", idle);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("idle:save")
    @ResponseBody
    public JsonResult save(@RequestBody IdleEntity idle) {
        idleService.save(idle);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("idle:update")
    @ResponseBody
    public JsonResult update(@RequestBody IdleEntity idle) {
        idleService.update(idle);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("idle:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        idleService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<IdleEntity> list = idleService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
