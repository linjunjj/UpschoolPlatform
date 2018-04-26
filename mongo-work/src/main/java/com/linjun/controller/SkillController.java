package com.linjun.controller;

import com.linjun.entity.SkillEntity;
import com.linjun.service.SkillService;
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
 * @create 2018/4/25.
 * @desc
 **/
@RestController
@RequestMapping("skill")
public class SkillController {
    @Autowired
    private SkillService skillService;
    @RequestMapping("/list")
    @RequiresPermissions("skill:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SkillEntity> addressList = skillService.queryList(query);
        int total = skillService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("report:info")
    public JsonResult info(@PathVariable("id") Long id) {
        SkillEntity skillEntity = skillService.queryObject(id);

        return JsonResult.ok().put("address", skillEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "report:save")
    public JsonResult save(@RequestBody SkillEntity skillEntity) {
        skillService.save(skillEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("report:update")
    public JsonResult update(@RequestBody SkillEntity skillEntity) {
        skillService.update(skillEntity);
        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("report:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        skillService.deleteBatch(ids);
        return JsonResult.ok();
    }

}
