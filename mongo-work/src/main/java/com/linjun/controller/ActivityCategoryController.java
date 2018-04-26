package com.linjun.controller;

import com.linjun.entity.ActivityCategoryEntity;
import com.linjun.service.ActivityCategoryService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import com.linjun.utils.TreeUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/26.
 * @desc
 **/
@RestController
@RequestMapping("activitycategory")
public class ActivityCategoryController {
    @Autowired
    private ActivityCategoryService activityCategoryService;
    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("activitycategory:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ActivityCategoryEntity> partTimeCategoryEntityList = activityCategoryService.queryList(query);
        int total = activityCategoryService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(partTimeCategoryEntityList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("parttimecategory:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        ActivityCategoryEntity activityCategoryEntity = activityCategoryService.queryObject(id);

        return JsonResult.ok().put("rentCategory", activityCategoryEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("parttimecategory:save")
    @ResponseBody
    public JsonResult save(@RequestBody ActivityCategoryEntity activityCategoryEntity) {
        activityCategoryService.save(activityCategoryEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("parttimecategory:update")
    @ResponseBody
    public JsonResult update(@RequestBody ActivityCategoryEntity partTimeCategoryEntity) {
        activityCategoryService.update(partTimeCategoryEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("parttimecategory:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        activityCategoryService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<ActivityCategoryEntity> list = activityCategoryService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
    /**
     * 查看信息(全部加载页面渲染太慢！)
     */
    @RequestMapping("/getAreaTree")
    public JsonResult getAreaTree() {
        List<ActivityCategoryEntity> list = activityCategoryService.queryList(new HashMap<String, Object>());
        for (ActivityCategoryEntity sysRegionEntity : list) {
            sysRegionEntity.setValue(sysRegionEntity.getId() + "");
            sysRegionEntity.setLabel(sysRegionEntity.getName());
        }
        List<ActivityCategoryEntity> node = TreeUtils.factorTree(list);

        return JsonResult.ok().put("node", node);
    }

    /**
     * 查询
     *
     * @return
     */
    @RequestMapping("/getCategorySelect")
    public JsonResult getCategorySelect() {
        Map<String, Object> map = new HashMap<>();
        map.put("parentId", "0");
        List<ActivityCategoryEntity> list = activityCategoryService.queryList(map);
        return JsonResult.ok().put("list", list);
    }
}
