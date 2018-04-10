package com.linjun.controller;

import com.linjun.entity.SignEntity;
import com.linjun.service.SignDetailService;
import com.linjun.service.SignService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/10.
 * @desc
 **/
@RestController
@RequestMapping("sign")
public class SignController {
    @Autowired
    private SignService signService;
    @RequestMapping("/list")
    @RequiresPermissions("sign:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SignEntity> addressList = signService.queryList(query);
        int total = signService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sign:info")
    public JsonResult info(@PathVariable("id") Long id) {
        SignEntity signEntity = signService.queryObject(id);

        return JsonResult.ok().put("address", signEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sign:save")
    public JsonResult save(@RequestBody SignEntity signEntity) {
        signService.save(signEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sign:update")
    public JsonResult update(@RequestBody SignEntity signEntity) {
        signService.update(signEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sign:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        signService.deleteBatch(ids);
        return JsonResult.ok();
    }




}
