package com.linjun.controller;

import com.linjun.entity.AdPositionEntity;
import com.linjun.service.AdPositionService;
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
 * @create 2018/4/10.
 * @desc
 **/
@RestController
@RequestMapping("adposition")
public class AdPositionController {
    @Autowired
    private AdPositionService adPositionService;
    @RequestMapping("/list")
    @RequiresPermissions("adposition:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<AdPositionEntity> adPositionList = adPositionService.queryList(query);
        int total = adPositionService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(adPositionList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("adposition:info")
    public JsonResult info(@PathVariable("id") Long id) {
        AdPositionEntity adPosition = adPositionService.queryObject(id);

        return JsonResult.ok().put("adPosition", adPosition);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("adposition:save")
    public JsonResult save(@RequestBody AdPositionEntity adPosition) {
        adPositionService.save(adPosition);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("adposition:update")
    public JsonResult update(@RequestBody AdPositionEntity adPosition) {
        adPositionService.update(adPosition);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("adposition:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        adPositionService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<AdPositionEntity> list = adPositionService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
