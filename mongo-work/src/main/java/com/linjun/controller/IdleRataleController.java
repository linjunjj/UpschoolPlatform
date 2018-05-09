package com.linjun.controller;

import com.linjun.entity.IdleRalateEntity;
import com.linjun.service.IdleRalateService;
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
@RequestMapping("idleralate")
public class IdleRataleController {
    @Autowired
    private IdleRalateService idleRalateService;
    @RequestMapping("/list")
    @RequiresPermissions("idleralate:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<IdleRalateEntity> idleRalateList = idleRalateService.queryList(query);
        int total = idleRalateService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(idleRalateList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("idleralate:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        IdleRalateEntity idleRalate = idleRalateService.queryObject(id);

        return JsonResult.ok().put("idleRalate", idleRalate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("idleralate:save")
    @ResponseBody
    public JsonResult save(@RequestBody IdleRalateEntity idleRalate) {
        idleRalateService.save(idleRalate);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("idleralate:update")
    @ResponseBody
    public JsonResult update(@RequestBody IdleRalateEntity idleRalate) {
        idleRalateService.update(idleRalate);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("idleralate:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        idleRalateService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<IdleRalateEntity> list = idleRalateService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
