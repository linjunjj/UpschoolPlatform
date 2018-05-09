package com.linjun.controller;

import com.linjun.entity.SkillEvaluateEntity;
import com.linjun.service.SkillEvaluateService;
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
@RequestMapping("skillevaluate")
public class SkillEvaluateController {
    @Autowired
    private SkillEvaluateService skillEvaluateService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("skillevaluate:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SkillEvaluateEntity> skillEvaluateList = skillEvaluateService.queryList(query);
        int total = skillEvaluateService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(skillEvaluateList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("skillevaluate:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        SkillEvaluateEntity skillEvaluate = skillEvaluateService.queryObject(id);

        return JsonResult.ok().put("skillEvaluate", skillEvaluate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("skillevaluate:save")
    @ResponseBody
    public JsonResult save(@RequestBody SkillEvaluateEntity skillEvaluate) {
        skillEvaluateService.save(skillEvaluate);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("skillevaluate:update")
    @ResponseBody
    public JsonResult update(@RequestBody SkillEvaluateEntity skillEvaluate) {
        skillEvaluateService.update(skillEvaluate);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("skillevaluate:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        skillEvaluateService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<SkillEvaluateEntity> list = skillEvaluateService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
