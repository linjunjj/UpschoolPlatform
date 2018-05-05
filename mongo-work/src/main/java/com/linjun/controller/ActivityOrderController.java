package com.linjun.controller;

import com.linjun.entity.UserOrderEntity;
import com.linjun.service.UserOrderService;
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
 * @create 2018/5/5.
 * @desc
 **/
@RestController
@RequestMapping("activityorder")
public class ActivityOrderController {
    @Autowired
    private UserOrderService userOrderService;
    @RequestMapping("/list")
    @RequiresPermissions("order:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        params.put("type","4");
        //查询列表数据
        Query query = new Query(params);

        List<UserOrderEntity> addressList = userOrderService.queryList(query);
        int total = userOrderService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:info")
    public JsonResult info(@PathVariable("id") Long id) {
        UserOrderEntity userOrderEntity = userOrderService.queryObject(id);
        return JsonResult.ok().put("address", userOrderEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:save")
    public JsonResult save(@RequestBody UserOrderEntity userOrderEntity) {
        userOrderService.save(userOrderEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:update")
    public JsonResult update(@RequestBody UserOrderEntity userOrderEntity) {
        userOrderService.update(userOrderEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        userOrderService.deleteBatch(ids);
        return JsonResult.ok();
    }
}
