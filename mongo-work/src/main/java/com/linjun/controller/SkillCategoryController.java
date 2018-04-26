package com.linjun.controller;

import com.linjun.entity.SkillCategoryEntity;
import com.linjun.service.SkillCategoryService;
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
@RequestMapping("skillcategory")
public class SkillCategoryController {
    @Autowired
    private SkillCategoryService skillCategoryService;
    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("skillcategory:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SkillCategoryEntity> rentCategoryList = skillCategoryService.queryList(query);
        int total = skillCategoryService.queryTotal(query);

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
        SkillCategoryEntity rentCategory = skillCategoryService.queryObject(id);

        return JsonResult.ok().put("rentCategory", rentCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("rentcategory:save")
    @ResponseBody
    public JsonResult save(@RequestBody SkillCategoryEntity skillCategoryEntity) {
        skillCategoryService.save(skillCategoryEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("rentcategory:update")
    @ResponseBody
    public JsonResult update(@RequestBody SkillCategoryEntity skillCategoryEntity) {
        skillCategoryService.update(skillCategoryEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("rentcategory:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        skillCategoryService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<SkillCategoryEntity> list = skillCategoryService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
    /**
     * 查看信息(全部加载页面渲染太慢！)
     */
    @RequestMapping("/getAreaTree")
    public JsonResult getAreaTree() {
        List<SkillCategoryEntity> list = skillCategoryService.queryList(new HashMap<String, Object>());
        for (SkillCategoryEntity sysRegionEntity : list) {
            sysRegionEntity.setValue(sysRegionEntity.getId() + "");
            sysRegionEntity.setLabel(sysRegionEntity.getName());
        }
        List<SkillCategoryEntity> node = TreeUtils.factorTree(list);

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
        List<SkillCategoryEntity> list = skillCategoryService.queryList(map);
        return JsonResult.ok().put("list", list);
    }

}
