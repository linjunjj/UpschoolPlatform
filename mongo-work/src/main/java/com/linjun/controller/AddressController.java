package com.linjun.controller;

import com.linjun.entity.AddressManger;
import com.linjun.service.AddressMangerService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressMangerService addressMangerService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("address:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<AddressManger> addressList = addressMangerService.queryList(query);
        int total = addressMangerService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("address:info")
    public JsonResult info(@PathVariable("id") Long id) {
        AddressManger address = addressMangerService.queryObject(id);

        return JsonResult.ok().put("address", address);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("address:save")
    public JsonResult save(@RequestBody AddressManger address) {
        addressMangerService.save(address);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("address:update")
    public JsonResult update(@RequestBody AddressManger address) {
        addressMangerService.update(address);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("address:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        addressMangerService.deleteBatch(ids);

        return JsonResult.ok();
    }
}
