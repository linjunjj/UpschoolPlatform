package com.linjun.controller;

import com.linjun.entity.IdleCategroyEntity;
import com.linjun.service.IdleCategoryService;
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
 * @create 2018/4/18.
 * @desc
 **/
@RestController
@RequestMapping("idlecategory")
public class IdleCategoryController {
    @Autowired
    private IdleCategoryService idleCategoryService;
    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("idlecategory:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<IdleCategroyEntity> rentCategoryList = idleCategoryService.queryList(query);
        int total = idleCategoryService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(rentCategoryList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("rentcategory:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        IdleCategroyEntity rentCategory = idleCategoryService.queryObject(id);

        return JsonResult.ok().put("rentCategory", rentCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("rentcategory:save")
    @ResponseBody
    public JsonResult save(@RequestBody IdleCategroyEntity idleCategroyEntity) {
        idleCategoryService.save(idleCategroyEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("rentcategory:update")
    @ResponseBody
    public JsonResult update(@RequestBody IdleCategroyEntity idleCategroyEntity) {
        idleCategoryService.update(idleCategroyEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("rentcategory:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        idleCategoryService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<IdleCategroyEntity> list = idleCategoryService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
    /**
     * 查看信息(全部加载页面渲染太慢！)
     */
    @RequestMapping("/getAreaTree")
    public JsonResult getAreaTree() {
        List<IdleCategroyEntity> list = idleCategoryService.queryList(new HashMap<String, Object>());
        for (IdleCategroyEntity sysRegionEntity : list) {
            sysRegionEntity.setValue(sysRegionEntity.getId() + "");
            sysRegionEntity.setLabel(sysRegionEntity.getName());
        }
        List<IdleCategroyEntity> node = TreeUtils.factorTree(list);

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
        List<IdleCategroyEntity> list = idleCategoryService.queryList(map);
        return JsonResult.ok().put("list", list);
    }

}
