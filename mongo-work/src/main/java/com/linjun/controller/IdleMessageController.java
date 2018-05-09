package com.linjun.controller;

import com.linjun.entity.IdleMessageEntity;
import com.linjun.entity.RentMessageEntity;
import com.linjun.service.IdleMessageService;
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
@RequestMapping("idlemessage")
public class IdleMessageController {
    @Autowired
    private IdleMessageService idleMessageService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("rentmessage:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<IdleMessageEntity> idleMessageEntities = idleMessageService.queryList(query);
        int total = idleMessageService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(idleMessageEntities, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("idlemessage:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        IdleMessageEntity idleMessageEntity = idleMessageService.queryObject(id);

        return JsonResult.ok().put("rentMessage", idleMessageEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("rentmessage:save")
    @ResponseBody
    public JsonResult save(@RequestBody IdleMessageEntity idleMessageEntity) {
        idleMessageService.save(idleMessageEntity);

        return JsonResult.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("rentmessage:update")
    @ResponseBody
    public JsonResult update(@RequestBody IdleMessageEntity idleMessageEntity) {
        idleMessageService.update(idleMessageEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("rentmessage:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        idleMessageService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<IdleMessageEntity> list = idleMessageService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
