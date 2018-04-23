package com.linjun.controller;

import com.linjun.entity.PartTimeEntity;
import com.linjun.service.PartTimeService;
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
 * @create 2018/4/23.
 * @desc
 **/
@RestController
@RequestMapping("parttimecategory")
public class PartTimeController {
    @Autowired
    private PartTimeService partTimeService;
    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("parttimecategory:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<PartTimeEntity> rentCategoryList = partTimeService.queryList(query);
        int total = partTimeService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(rentCategoryList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("parttimecategory:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        PartTimeEntity partTimeEntity = partTimeService.queryObject(id);

        return JsonResult.ok().put("rentCategory", partTimeEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("parttimecategory:save")
    @ResponseBody
    public JsonResult save(@RequestBody PartTimeEntity partTimeEntity) {
        partTimeService.save(partTimeEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("parttimecategory:update")
    @ResponseBody
    public JsonResult update(@RequestBody PartTimeEntity partTimeEntity) {
        partTimeService.update(partTimeEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("parttimecategory:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        partTimeService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<PartTimeEntity> list = partTimeService.queryList(params);

        return JsonResult.ok().put("list", list);
    }


}
