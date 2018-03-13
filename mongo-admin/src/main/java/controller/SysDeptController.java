package controller;

import com.linjun.controller.AbstractController;
import com.linjun.entity.SysDeptEntity;
import com.linjun.service.SysDeptService;
import com.linjun.utils.Constant;
import com.linjun.utils.JsonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/13.
 * @desc
 **/
@RestController
@RequestMapping("/sys/dept")
public class SysDeptController extends AbstractController {
    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:dept:list")
    public JsonResult list() {
        Map<String, Object> map = new HashMap<>();
        //如果不是超级管理员，则只能查询本部门及子部门数据
        if (getUserId() != Constant.SUPER_ADMIN) {
            map.put("deptFilter", sysDeptService.getSubDeptIdList(getDeptId()));
        }
        List<SysDeptEntity> deptList = sysDeptService.queryList(map);
        return JsonResult.ok().put("list", deptList);
    }

    /**
     * 选择部门(添加、修改菜单)
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:dept:select")
    public JsonResult select() {
        Map<String, Object> map = new HashMap<>();
        //如果不是超级管理员，则只能查询本部门及子部门数据
        if (getUserId() != Constant.SUPER_ADMIN) {
            map.put("deptFilter", sysDeptService.getSubDeptIdList(getDeptId()));
        }
        List<SysDeptEntity> deptList = sysDeptService.queryList(map);

        //添加一级部门
        if (getUserId() == Constant.SUPER_ADMIN) {
            SysDeptEntity root = new SysDeptEntity();
            root.setDeptId(0L);
            root.setName("一级部门");
            root.setParentId(-1L);
            root.setOpen(true);
            deptList.add(root);
        }

        return JsonResult.ok().put("deptList", deptList);
    }

    /**
     * 上级部门Id(管理员则为0)
     */
    @RequestMapping("/info")
    @RequiresPermissions("sys:dept:list")
    public JsonResult info() {
        long deptId = 0;
        if (getUserId() != Constant.SUPER_ADMIN) {
            SysDeptEntity dept = sysDeptService.queryObject(getDeptId());
            deptId = dept.getParentId();
        }

        return JsonResult.ok().put("deptId", deptId);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{deptId}")
    @RequiresPermissions("sys:dept:info")
    public JsonResult info(@PathVariable("deptId") Long deptId) {
        SysDeptEntity dept = sysDeptService.queryObject(deptId);

        return JsonResult.ok().put("dept", dept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:dept:save")
    public JsonResult save(@RequestBody SysDeptEntity dept) {
        sysDeptService.save(dept);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:dept:update")
    public JsonResult update(@RequestBody SysDeptEntity dept) {
        sysDeptService.update(dept);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:dept:delete")
    public JsonResult delete(long deptId) {
        //判断是否有子部门
        List<Long> deptList = sysDeptService.queryDetpIdList(deptId);
        if (deptList.size() > 0) {
            return JsonResult.error("请先删除子部门");
        }

        sysDeptService.delete(deptId);

        return JsonResult.ok();
    }

}