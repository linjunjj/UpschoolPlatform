package com.linjun.controller;



import com.linjun.entity.TopicPostionEntity;
import com.linjun.service.TopicPostionService;
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
@RequestMapping("topicposition")
public class TopicPostionController {
    @Autowired
    private TopicPostionService topicPostionService;
    @RequestMapping("/list")
    @RequiresPermissions("topicposition:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<TopicPostionEntity> adPositionList = topicPostionService.queryList(query);
        int total = topicPostionService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(adPositionList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("topicposition:info")
    public JsonResult info(@PathVariable("id") Long id) {
        TopicPostionEntity topicPostionEntity = topicPostionService.queryObject(id);

        return JsonResult.ok().put("adPosition", topicPostionEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("adposition:save")
    public JsonResult save(@RequestBody TopicPostionEntity topicPostionEntity) {
        topicPostionService.save(topicPostionEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("adposition:update")
    public JsonResult update(@RequestBody TopicPostionEntity topicPostionEntity) {
        topicPostionService.update(topicPostionEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("adposition:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        topicPostionService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<TopicPostionEntity> list = topicPostionService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
}
