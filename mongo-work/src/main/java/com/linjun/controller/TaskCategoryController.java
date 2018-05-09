package com.linjun.controller;

import com.linjun.entity.TaskLabelEntity;
import com.linjun.service.TaskLabelService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import com.linjun.utils.TreeUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/23.
 * @desc
 **/
@RestController
@RequestMapping("taskcategory")
public class TaskCategoryController {
    @Autowired
    private TaskLabelService taskLabelService;
    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("taskcategory:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<TaskLabelEntity> rentCategoryList = taskLabelService.queryList(query);
        int total = taskLabelService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(rentCategoryList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }
    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("taskcategory:info")
    @ResponseBody
    public JsonResult info(@PathVariable("id") Long id) {
        TaskLabelEntity taskLabelEntity = taskLabelService.queryObject(id);

        return JsonResult.ok().put("rentCategory", taskLabelEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("taskcategory:save")
    @ResponseBody
    public JsonResult save(@RequestBody TaskLabelEntity taskLabelEntity) {
        taskLabelService.save(taskLabelEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("taskcategory:update")
    @ResponseBody
    public JsonResult update(@RequestBody TaskLabelEntity taskLabelEntity) {
        taskLabelService.update(taskLabelEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("taskcategory:delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Long[]ids) {
        taskLabelService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<TaskLabelEntity> list = taskLabelService.queryList(params);

        return JsonResult.ok().put("list", list);
    }
    /**
     * 查看信息(全部加载页面渲染太慢！)
     */
    @RequestMapping("/getAreaTree")
    public JsonResult getAreaTree() {
        List<TaskLabelEntity> list = taskLabelService.queryList(new HashMap<String, Object>());
        for (TaskLabelEntity sysRegionEntity : list) {
            sysRegionEntity.setValue(sysRegionEntity.getId() + "");
            sysRegionEntity.setLabel(sysRegionEntity.getName());
        }
        List<TaskLabelEntity> node = TreeUtils.factorTree(list);

        return JsonResult.ok().put("node", node);
    }

    /**
     * 查询
     *
     * @return
     */
    @RequestMapping("/getCategorySelect")
    public JsonResult getCategorySelect() {
        Map<String, Object> map = new HashMap<>();
        map.put("parentId", "0");
        List<TaskLabelEntity> list = taskLabelService.queryList(map);
        return JsonResult.ok().put("list", list);
    }
}
