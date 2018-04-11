package com.linjun.controller;

import com.linjun.entity.InviteRecordEntity;
import com.linjun.service.InviteRecordService;
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
 * @create 2018/4/11.
 * @desc
 **/
@RestController
@RequestMapping("inviterecord")
public class InviteRecordController {
    @Autowired
    private InviteRecordService inviteRecordService;


    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("inviterecord:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<InviteRecordEntity> suggestList = inviteRecordService.queryList(query);
        int total = inviteRecordService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(suggestList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("inviterecord:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        InviteRecordEntity inviteRecordEntity = inviteRecordService.queryObject(id);

        return JsonResult.ok().put("suggest", inviteRecordEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("inviterecord:save")
    @ResponseBody
    public JsonResult save(@RequestBody InviteRecordEntity inviteRecordEntity) {
        inviteRecordService.save(inviteRecordEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("inviterecord:update")
    @ResponseBody
    public JsonResult update(@RequestBody InviteRecordEntity inviteRecordEntity) {
        inviteRecordService.update(inviteRecordEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("inviterecord:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        inviteRecordService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<InviteRecordEntity> list = inviteRecordService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
