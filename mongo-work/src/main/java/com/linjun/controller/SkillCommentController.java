package com.linjun.controller;

import com.linjun.entity.SkillCommentEntity;
import com.linjun.service.SkillCommentService;
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
@RequestMapping("skillcomment")
public class SkillCommentController {
    @Autowired
    private SkillCommentService skillCommentService;
    @RequestMapping("/list")
    @RequiresPermissions("skillcomment:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SkillCommentEntity> skillCommentList = skillCommentService.queryList(query);
        int total = skillCommentService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(skillCommentList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("skillcomment:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        SkillCommentEntity skillComment = skillCommentService.queryObject(id);

        return JsonResult.ok().put("skillComment", skillComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("skillcomment:save")
    @ResponseBody
    public JsonResult save(@RequestBody SkillCommentEntity skillComment) {
        skillCommentService.save(skillComment);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("skillcomment:update")
    @ResponseBody
    public JsonResult update(@RequestBody SkillCommentEntity skillComment) {
        skillCommentService.update(skillComment);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("skillcomment:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        skillCommentService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<SkillCommentEntity> list = skillCommentService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
