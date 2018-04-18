package com.linjun.controller;

import java.util.List;
import java.util.Map;

import com.linjun.entity.RentMessageEntity;
import com.linjun.service.RentMessageService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 租房留言Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-04-18 21:18:49
 */
@RestController
@RequestMapping("rentmessage")
public class RentMessageController {
    @Autowired
    private RentMessageService rentMessageService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("rentmessage:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<RentMessageEntity> rentMessageList = rentMessageService.queryList(query);
        int total = rentMessageService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(rentMessageList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("rentmessage:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        RentMessageEntity rentMessage = rentMessageService.queryObject(id);

        return JsonResult.ok().put("rentMessage", rentMessage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("rentmessage:save")
    @ResponseBody
    public JsonResult save(@RequestBody RentMessageEntity rentMessage) {
        rentMessageService.save(rentMessage);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("rentmessage:update")
    @ResponseBody
    public JsonResult update(@RequestBody RentMessageEntity rentMessage) {
        rentMessageService.update(rentMessage);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("rentmessage:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        rentMessageService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<RentMessageEntity> list = rentMessageService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
