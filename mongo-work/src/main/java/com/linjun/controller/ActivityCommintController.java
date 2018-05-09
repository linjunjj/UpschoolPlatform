package com.linjun.controller;

import com.linjun.entity.ActivityCommentEntity;
import com.linjun.service.ActivityCommentService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/5/9.
 * @desc
 **/
@Controller
@RequestMapping("activitycommint")
public class ActivityCommintController {
    @Autowired
    private ActivityCommentService activityCommintService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("activitycommint:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ActivityCommentEntity> activityCommintList = activityCommintService.queryList(query);
        int total = activityCommintService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(activityCommintList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("activitycommint:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        ActivityCommentEntity activityCommentEntity = activityCommintService.queryObject(id);

        return JsonResult.ok().put("activityCommint", activityCommentEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("activitycommint:save")
    @ResponseBody
    public JsonResult save(@RequestBody ActivityCommentEntity activityCommentEntity) {
        activityCommintService.save(activityCommentEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("activitycommint:update")
    @ResponseBody
    public JsonResult update(@RequestBody ActivityCommentEntity activityCommint) {
        activityCommintService.update(activityCommint);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("activitycommint:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        activityCommintService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<ActivityCommentEntity> list = activityCommintService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
