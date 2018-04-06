package com.linjun.controller;

import com.linjun.entity.UserEntity;
import com.linjun.service.UserService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import com.linjun.utils.excel.ExcelExport;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
    @RequestMapping("/info/{id}")
    @RequiresPermissions("user:info")
    public  JsonResult info(@PathVariable("id") Long id){
        UserEntity userEntity=userService.queryObject(id);
        return JsonResult.ok().put("user",userEntity);
    }

    @RequestMapping("/save")
    @RequiresPermissions("user:save")
    public  JsonResult save(@RequestBody UserEntity userEntity){
        userService.save(userEntity);
        return JsonResult.ok();
    }

    @RequestMapping("/update")
    @RequiresPermissions("user:update")
    public  JsonResult update(@RequestBody UserEntity userEntity){
        userService.update(userEntity);
        return  JsonResult.ok();
    }

    @RequestMapping("/delete")
    @RequiresPermissions("user:delete")
    public  JsonResult delete(@RequestBody Long[] ids){
        userService.deleteBatch(ids);
        return JsonResult.ok();
    }

    @RequestMapping("/queryAll")
    public  JsonResult queryAll(@RequestParam Map<String,Object> params){
        List<UserEntity> userEntityList=userService.queryList(params);
        return JsonResult.ok().put("list",userEntityList);
    }

    @RequestMapping("/queryTotal")
    public  JsonResult queryTotal(@RequestParam Map<String,Object> params){
        int sum=userService.queryTotal(params);
        return  JsonResult.ok().put("userSum",sum);
    }

    @RequestMapping("/export")
    @RequiresPermissions("user:export")
    public  JsonResult export(@RequestParam Map<String,Object> params, HttpServletResponse response){
        List<UserEntity> userEntityList=userService.queryList(params);
        ExcelExport excelExport=new ExcelExport("用户列表");
        String[] header=new String[]{"用户名称","性别","会员等级","手机号码"};
        List<Map<String,Object>> list=new ArrayList<>();
        if (userEntityList!=null&&userEntityList.size()!=0){
            for (UserEntity userEntity:
                 userEntityList) {
                LinkedHashMap<String,Object> map=new LinkedHashMap<>();
                map.put("USERNAME", userEntity.getUserName());
                map.put("GENDER", userEntity.getGender());
                map.put("LEVEL_NAME", userEntity.getLast_login_ip());
                map.put("MOBILE", userEntity.getMobile());
                list.add(map);
            }
        }
        excelExport.addSheetByMap("会员", list, header);
        excelExport.export(response);
        return JsonResult.ok();
    }

}
