package com.linjun.controller;

import com.linjun.entity.SysMacroEntity;
import com.linjun.service.SysMacroService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("sys/macro")
public class SysMacroController {
    @Autowired
    private SysMacroService sysMacroService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:macro:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SysMacroEntity> sysMacroList = sysMacroService.queryList(query);
        int total = sysMacroService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(sysMacroList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{macroId}")
    @RequiresPermissions("sys:macro:info")
    public JsonResult info(@PathVariable("macroId") Long macroId) {
        SysMacroEntity sysMacro = sysMacroService.queryObject(macroId);

        return JsonResult.ok().put("macro", sysMacro);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:macro:save")
    public JsonResult save(@RequestBody SysMacroEntity sysMacro) {
        sysMacroService.save(sysMacro);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:macro:update")
    public JsonResult update(@RequestBody SysMacroEntity sysMacro) {
        sysMacroService.update(sysMacro);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:macro:delete")
    public JsonResult delete(@RequestBody Long[] macroIds) {
        sysMacroService.deleteBatch(macroIds);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<SysMacroEntity> list = sysMacroService.queryList(params);

        return JsonResult.ok().put("list", list);
    }

    /**
     * 查询数据字典
     *
     * @param value
     * @return
     */
    @RequestMapping("/queryMacrosByValue")
    public JsonResult queryMacrosByValue(@RequestParam String value) {

        List<SysMacroEntity> list = sysMacroService.queryMacrosByValue(value);

        return JsonResult.ok().put("list", list);
    }
}
