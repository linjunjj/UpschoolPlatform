package com.linjun.controller;

import com.linjun.entity.AdEntity;
import com.linjun.service.AdService;
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
@RequestMapping("ad")
public class AdController {
    @Autowired
    private AdService adService;
    @RequestMapping("/list")
    @RequiresPermissions("ad:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<AdEntity> addressList = adService.queryList(query);
        int total = adService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ad:info")
    public JsonResult info(@PathVariable("id") Long id) {
        AdEntity adEntity = adService.queryObject(id);

        return JsonResult.ok().put("address", adEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ad:save")
    public JsonResult save(@RequestBody AdEntity adEntity) {
        adService.save(adEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ad:update")
    public JsonResult update(@RequestBody AdEntity adEntity) {
        adService.update(adEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ad:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        adService.deleteBatch(ids);
        return JsonResult.ok();
    }

}
