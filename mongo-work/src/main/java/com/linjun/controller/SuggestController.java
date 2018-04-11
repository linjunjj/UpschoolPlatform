package com.linjun.controller;

import java.util.List;
import java.util.Map;

import com.linjun.entity.SuggestEntity;
import com.linjun.service.SuggestService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 建议Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-04-11 08:14:26
 */
@Controller
@RequestMapping("suggest")
public class SuggestController {
    @Autowired
    private SuggestService suggestService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("suggest:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SuggestEntity> suggestList = suggestService.queryList(query);
        int total = suggestService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(suggestList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("suggest:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        SuggestEntity suggest = suggestService.queryObject(id);

        return JsonResult.ok().put("suggest", suggest);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("suggest:save")
    @ResponseBody
    public JsonResult save(@RequestBody SuggestEntity suggest) {
        suggestService.save(suggest);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("suggest:update")
    @ResponseBody
    public JsonResult update(@RequestBody SuggestEntity suggest) {
        suggestService.update(suggest);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("suggest:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        suggestService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<SuggestEntity> list = suggestService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
