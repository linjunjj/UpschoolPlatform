package com.linjun.controller;

import com.linjun.entity.ReportEntity;
import com.linjun.service.ReportService;
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
 * @create 2018/4/11.
 * @desc
 **/
@RestController
@RequestMapping("report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @RequestMapping("/list")
    @RequiresPermissions("report:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ReportEntity> addressList = reportService.queryList(query);
        int total = reportService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("report:info")
    public JsonResult info(@PathVariable("id") Long id) {
        ReportEntity address = reportService.queryObject(id);

        return JsonResult.ok().put("address", address);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("report:save")
    public JsonResult save(@RequestBody ReportEntity reportEntity) {
        reportService.save(reportEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("report:update")
    public JsonResult update(@RequestBody ReportEntity reportEntity) {
        reportService.update(reportEntity);
        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("report:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        reportService.deleteBatch(ids);
        return JsonResult.ok();
    }

}
