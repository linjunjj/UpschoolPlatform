package controller;

import com.linjun.annotation.SysLog;
import com.linjun.controller.AbstractController;
import com.linjun.entity.SysConfigEntity;
import com.linjun.service.SysConfigService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageBean;
import com.linjun.utils.Query;
import com.linjun.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/13.
 * @desc
 **/
@RestController
@RequestMapping("/sys/config")
public class SysConfigController extends AbstractController {
    @Autowired
    private SysConfigService sysConfigService;
    @RequestMapping("list")
    @RequiresPermissions("sys:config:list")
    public JsonResult list(@RequestParam Map<String,Object> map){
        Query query=new Query(map);
        List<SysConfigEntity> configList = sysConfigService.queryList(query);
        int total = sysConfigService.queryTotal(query);
        PageBean pageBean=new PageBean(configList,total,query.getLimit(),query.getPage());
        return  JsonResult.ok().put("page",pageBean);
    }
    /**
     * 配置信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:config:info")
    public JsonResult info(@PathVariable("id") Long id) {
        SysConfigEntity config = sysConfigService.queryObject(id);

        return JsonResult.ok().put("config", config);
    }

    /**
     * 保存配置
     */
    @SysLog("保存配置")
    @RequestMapping("/save")
    @RequiresPermissions("sys:config:save")
    public JsonResult save(@RequestBody SysConfigEntity config) {
        ValidatorUtils.validateEntity(config);

        sysConfigService.save(config);

        return JsonResult.ok();
    }

    /**
     * 修改配置
     */
    @SysLog("修改配置")
    @RequestMapping("/update")
    @RequiresPermissions("sys:config:update")
    public JsonResult update(@RequestBody SysConfigEntity config) {
        ValidatorUtils.validateEntity(config);

        sysConfigService.update(config);

        return JsonResult.ok();
    }

    /**
     * 删除配置
     */
    @SysLog("删除配置")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:config:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        sysConfigService.deleteBatch(ids);

        return JsonResult.ok();
    }

}
