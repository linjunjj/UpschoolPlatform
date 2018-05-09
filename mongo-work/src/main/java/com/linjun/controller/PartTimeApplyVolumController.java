package com.linjun.controller;

import com.alibaba.fastjson.JSONReader;
import com.linjun.entity.PartTimeApplyVolumEntity;
import com.linjun.service.PartTimeApplyVolumService;
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
@RequestMapping("parttimeapplyvolum")
public class PartTimeApplyVolumController {
    @Autowired
    private PartTimeApplyVolumService parttimeApplyvolumService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("parttimeapplyvolum:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<PartTimeApplyVolumEntity> parttimeApplyvolumList = parttimeApplyvolumService.queryList(query);
        int total = parttimeApplyvolumService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(parttimeApplyvolumList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("parttimeapplyvolum:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        PartTimeApplyVolumEntity parttimeApplyvolum = parttimeApplyvolumService.queryObject(id);

        return JsonResult.ok().put("parttimeApplyvolum", parttimeApplyvolum);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("parttimeapplyvolum:save")
    @ResponseBody
    public JsonResult save(@RequestBody PartTimeApplyVolumEntity parttimeApplyvolum) {
        parttimeApplyvolumService.save(parttimeApplyvolum);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("parttimeapplyvolum:update")
    @ResponseBody
    public JsonResult update(@RequestBody PartTimeApplyVolumEntity parttimeApplyvolum) {
        parttimeApplyvolumService.update(parttimeApplyvolum);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("parttimeapplyvolum:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        parttimeApplyvolumService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<PartTimeApplyVolumEntity> list = parttimeApplyvolumService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
