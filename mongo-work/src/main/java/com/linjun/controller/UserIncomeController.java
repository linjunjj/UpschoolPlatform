package com.linjun.controller;

import com.linjun.entity.UserIncomeEntity;
import com.linjun.service.UserIncomeService;
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
@RequestMapping("userincome")
public class UserIncomeController {
  @Autowired
    private UserIncomeService userIncomeService;
    @RequestMapping("/list")
    @RequiresPermissions("address:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<UserIncomeEntity> addressList = userIncomeService.queryList(query);
        int total = userIncomeService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("address:info")
    public JsonResult info(@PathVariable("id") Long id) {
        UserIncomeEntity address = userIncomeService.queryObject(id);

        return JsonResult.ok().put("address", address);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("address:save")
    public JsonResult save(@RequestBody UserIncomeEntity userIncomeEntity) {
        userIncomeService.save(userIncomeEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("address:update")
    public JsonResult update(@RequestBody UserIncomeEntity userIncomeEntity) {
        userIncomeService.update(userIncomeEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("address:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        userIncomeService.deleteBatch(ids);
        return JsonResult.ok();
    }



}
