package com.linjun.controller;

import com.linjun.entity.UserEntity;
import com.linjun.service.UserService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    @RequiresPermissions("user:list")
    public JsonResult list (@RequestParam Map<String,Object> params){
        Query query=new Query(params);
        List<UserEntity> userEntityList=userService.queryList(query);
        int total =userService.queryTotal(query);
        PageUtils pageUtils=new PageUtils(userEntityList,total,query.getLimit(),query.getPage());
        return JsonResult.ok().put("page",pageUtils);
    }




}
