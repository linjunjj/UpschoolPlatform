package com.linjun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linjun.entity.RentCategoryEntity;
import com.linjun.entity.SysRegionEntity;
import com.linjun.service.RentCategoryService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import com.linjun.utils.TreeUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("rentcategory")
public class RentCategoryController {
    @Autowired
    private RentCategoryService rentCategoryService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("rentcategory:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<RentCategoryEntity> rentCategoryList = rentCategoryService.queryList(query);
        int total = rentCategoryService.queryTotal(query);

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
        RentCategoryEntity rentCategory = rentCategoryService.queryObject(id);

        return JsonResult.ok().put("rentCategory", rentCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("rentcategory:save")
    @ResponseBody
    public JsonResult save(@RequestBody RentCategoryEntity rentCategory) {
        rentCategoryService.save(rentCategory);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("rentcategory:update")
    @ResponseBody
    public JsonResult update(@RequestBody RentCategoryEntity rentCategory) {
        rentCategoryService.update(rentCategory);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("rentcategory:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        rentCategoryService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<RentCategoryEntity> list = rentCategoryService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
    /**
     * 查看信息(全部加载页面渲染太慢！)
     */
    @RequestMapping("/getAreaTree")
    public JsonResult getAreaTree() {
        List<RentCategoryEntity> list = rentCategoryService.queryList(new HashMap<String, Object>());
        for (RentCategoryEntity sysRegionEntity : list) {
            sysRegionEntity.setValue(sysRegionEntity.getId() + "");
            sysRegionEntity.setLabel(sysRegionEntity.getName());
        }
        List<RentCategoryEntity> node = TreeUtils.factorTree(list);

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
        List<RentCategoryEntity> list = rentCategoryService.queryList(map);
        return JsonResult.ok().put("list", list);
    }
}
