package com.linjun.controller;

import com.linjun.entity.TopicEntity;
import com.linjun.service.TopicService;
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
 * @create 2018/9/24.
 * @desc
 **/
@RestController
@RequestMapping("topic")
public class TopicController {
    @Autowired
    private TopicService topicService;
    @RequestMapping("/list")
    @RequiresPermissions("topic:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<TopicEntity> addressList = topicService.queryList(query);
        int total = topicService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("topic:info")
    public JsonResult info(@PathVariable("id") Long id) {
        TopicEntity topicEntity = topicService.queryObject(id);

        return JsonResult.ok().put("address", topicEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ad:save")
    public JsonResult save(@RequestBody TopicEntity topicEntity) {
        topicService.save(topicEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ad:update")
    public JsonResult update(@RequestBody TopicEntity topicEntity) {
        topicService.update(topicEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ad:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        topicService.deleteBatch(ids);
        return JsonResult.ok();
    }

}
