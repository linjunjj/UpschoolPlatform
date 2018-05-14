package com.linjun.controller;

import com.linjun.entity.PartTimeCategoryEntity;
import com.linjun.entity.PartTimeEntity;
import com.linjun.service.PartTimeCategoryService;
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
 * @create 2018/4/23.
 * @desc
 **/
@RestController
@RequestMapping("parttimecategory")
public class PartTimeCategoryController {
    @Autowired
    private PartTimeCategoryService partTimeCategoryService;
    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("parttimecategory:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<PartTimeCategoryEntity> partTimeCategoryEntityList = partTimeCategoryService.queryList(query);
        int total = partTimeCategoryService.queryTotal(query);

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
        PartTimeCategoryEntity partTimeCategoryEntity = partTimeCategoryService.queryObject(id);

        return JsonResult.ok().put("rentCategory", partTimeCategoryEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("parttimecategory:save")
    @ResponseBody
    public JsonResult save(@RequestBody PartTimeCategoryEntity partTimeCategoryEntity) {
        partTimeCategoryService.save(partTimeCategoryEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("parttimecategory:update")
    @ResponseBody
    public JsonResult update(@RequestBody PartTimeCategoryEntity partTimeCategoryEntity) {
        partTimeCategoryService.update(partTimeCategoryEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("parttimecategory:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        partTimeCategoryService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<PartTimeCategoryEntity> list = partTimeCategoryService.queryList(params);

        return JsonResult.ok().put("list", list);
    }

    @RequestMapping("/getAreaTree")
    public JsonResult getAreaTree() {
        List<PartTimeCategoryEntity> list = partTimeCategoryService.queryList(new HashMap<String, Object>());
        for (PartTimeCategoryEntity sysRegionEntity : list) {
            sysRegionEntity.setValue(sysRegionEntity.getId() + "");
            sysRegionEntity.setLabel(sysRegionEntity.getName());
        }
        List<PartTimeCategoryEntity> node = TreeUtils.factorTree(list);

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
        List<PartTimeCategoryEntity> list = partTimeCategoryService.queryList(map);
        return JsonResult.ok().put("list", list);
    }
}
