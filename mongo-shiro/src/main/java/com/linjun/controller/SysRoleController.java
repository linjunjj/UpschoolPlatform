package com.linjun.controller;

import com.linjun.annotation.SysLog;
import com.linjun.entity.SysRoleEntity;
import com.linjun.service.SysRoleDepService;
import com.linjun.service.SysRoleMenuService;
import com.linjun.service.SysRoleService;
import com.linjun.utils.Constant;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageBean;
import com.linjun.utils.Query;
import com.linjun.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/11.
 * @desc
 **/
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysRoleDepService sysRoleDeptService;

    /**
     * 角色列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:role:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //如果不是超级管理员，则只查询自己创建的角色列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            params.put("createUserId", getUserId());
        }

        //查询列表数据
        Query query = new Query(params);
        List<SysRoleEntity> list = sysRoleService.queryList(query);
        int total = sysRoleService.queryTotal(query);

        PageBean pageUtil = new PageBean(list, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }

    /**
     * 角色列表
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:role:select")
    public JsonResult select() {
        Map<String, Object> map = new HashMap<>();

        //如果不是超级管理员，则只查询自己所拥有的角色列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            map.put("createUserId", getUserId());
        }
        List<SysRoleEntity> list = sysRoleService.queryList(map);

        return JsonResult.ok().put("list", list);
    }

    /**
     * 角色信息
     */
    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public JsonResult info(@PathVariable("roleId") Long roleId) {
        SysRoleEntity role = sysRoleService.queryObject(roleId);

        //查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
        role.setMenuIdList(menuIdList);

        //查询角色对应的部门
        List<Long> deptIdList = sysRoleDeptService.queryDeptIdList(roleId);
        role.setDeptIdList(deptIdList);

        return JsonResult.ok().put("role", role);
    }

    /**
     * 保存角色
     */
    @SysLog("保存角色")
    @RequestMapping("/save")
    @RequiresPermissions("sys:role:save")
    public JsonResult save(@RequestBody SysRoleEntity role) {
        ValidatorUtils.validateEntity(role);

        role.setCreateUserId(getUserId());
        sysRoleService.save(role);

        return JsonResult.ok();
    }

    /**
     * 修改角色
     */
    @SysLog("修改角色")
    @RequestMapping("/update")
    @RequiresPermissions("sys:role:update")
    public JsonResult update(@RequestBody SysRoleEntity role) {
        ValidatorUtils.validateEntity(role);

        role.setCreateUserId(getUserId());
        sysRoleService.update(role);

        return JsonResult.ok();
    }

    /**
     * 删除角色
     */
    @SysLog("删除角色")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public JsonResult delete(@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatch(roleIds);

        return JsonResult.ok();
    }
}