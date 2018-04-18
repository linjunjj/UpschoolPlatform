package com.linjun.controller;

import java.util.List;
import java.util.Map;

import com.linjun.entity.RentEntity;
import com.linjun.service.RentServcie;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("rent")
public class RentController {
    @Autowired
    private RentServcie rentService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("rent:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<RentEntity> rentList = rentService.queryList(query);
        int total = rentService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(rentList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("rent:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        RentEntity rent = rentService.queryObject(id);

        return JsonResult.ok().put("rent", rent);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("rent:save")
    @ResponseBody
    public JsonResult save(@RequestBody RentEntity rent) {
        rentService.save(rent);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("rent:update")
    @ResponseBody
    public JsonResult update(@RequestBody RentEntity rent) {
        rentService.update(rent);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("rent:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        rentService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<RentEntity> list = rentService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
