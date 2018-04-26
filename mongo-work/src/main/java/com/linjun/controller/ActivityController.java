package com.linjun.controller;

import com.linjun.entity.ActivityEntity;
import com.linjun.service.AcitvityService;
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
 * @create 2018/4/26.
 * @desc
 **/
@RestController
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private AcitvityService acitvityService;
    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("activity:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ActivityEntity> rentCategoryList = acitvityService.queryList(query);
        int total = acitvityService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(rentCategoryList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("parttime:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        ActivityEntity activityEntity = acitvityService.queryObject(id);

        return JsonResult.ok().put("rentCategory", activityEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("parttime:save")
    @ResponseBody
    public JsonResult save(@RequestBody ActivityEntity activityEntity) {
        acitvityService.save(activityEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("parttime:update")
    @ResponseBody
    public JsonResult update(@RequestBody ActivityEntity activityEntity) {
        acitvityService.update(activityEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("parttime:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        acitvityService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<ActivityEntity> list = acitvityService.queryList(params);

        return JsonResult.ok().put("list", list);
    }


}
