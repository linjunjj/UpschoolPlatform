package com.linjun.controller;

import com.linjun.entity.UserLevelEntity;
import com.linjun.service.UserLevelService;
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
@RequestMapping("userlevel")
public class UserLevelController {
    @Autowired
    private UserLevelService userLevelService;
    @RequestMapping("/list")
    @RequiresPermissions("userlevel:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<UserLevelEntity> addressList = userLevelService.queryList(query);
        int total = userLevelService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("userlevel:info")
    public JsonResult info(@PathVariable("id") Long id) {
        UserLevelEntity userLevelEntity = userLevelService.queryObject(id);

        return JsonResult.ok().put("address", userLevelEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("userlevel:save")
    public JsonResult save(@RequestBody UserLevelEntity userLevelEntity) {
        userLevelService.save(userLevelEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("userlevel:update")
    public JsonResult update(@RequestBody UserLevelEntity userLevelEntity) {
        userLevelService.update(userLevelEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("userlevel:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        userLevelService.deleteBatch(ids);
        return JsonResult.ok();
    }

}
