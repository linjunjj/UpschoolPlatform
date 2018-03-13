package controller;

import com.alibaba.fastjson.JSON;
import com.linjun.oss.CloudStorageConfig;
import com.linjun.oss.OSSFactory;
import com.linjun.service.SysConfigService;
import com.linjun.utils.*;
import com.linjun.validator.ValidatorUtils;
import com.linjun.validator.group.AliyunGroup;
import com.linjun.validator.group.QcloudGroup;
import com.linjun.validator.group.QiniuGroup;
import entity.SysOssEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import service.SysOssService;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/13.
 * @desc
 **/
@RestController
@RequestMapping("sys/oss")
public class SysOssController {
    @Autowired
    private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;
    /*获取列表消息*/
     @RequestMapping("/list")
    @RequiresPermissions("sys:oss:all")
    public JsonResult list (Map<String,Object> map){
         Query query=new Query(map);
         List<SysOssEntity> sysOssEntityList=sysOssService.queryList(query);
         int total=sysOssService.queryTotal(query);
         PageBean pageBean=new PageBean(sysOssEntityList,total,query.getLimit(),query.getPage());
         return JsonResult.ok().put("page",pageBean);
     }
    /*云配置消息*/
    @RequestMapping("/config")
    @RequiresPermissions("sys:oss:all")
    public JsonResult config(){
        CloudStorageConfig storageConfig=sysConfigService.getConfigObject(KEY,CloudStorageConfig.class);
        return JsonResult.ok().put("config",storageConfig);
    }



    /**
     * 保存云存储配置信息
     */
    @RequestMapping("/saveConfig")
    @RequiresPermissions("sys:oss:all")
    public JsonResult saveConfig(@RequestBody CloudStorageConfig config) {
        //校验类型
        ValidatorUtils.validateEntity(config);

        if (config.getType() == Constant.CloudService.QINIU.getValue()) {
            //校验七牛数据
            ValidatorUtils.validateEntity(config, QiniuGroup.class);
        } else if (config.getType() == Constant.CloudService.ALIYUN.getValue()) {
            //校验阿里云数据
            ValidatorUtils.validateEntity(config, AliyunGroup.class);
        } else if (config.getType() == Constant.CloudService.QCLOUD.getValue()) {
            //校验腾讯云数据
            ValidatorUtils.validateEntity(config, QcloudGroup.class);
        }


        sysConfigService.updateValueByKey(KEY, JSON.toJSONString(config));

        return JsonResult.ok();
    }


    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    @RequiresPermissions("sys:oss:all")
    public JsonResult upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        //上传文件
        String url = OSSFactory.build().upload(file);

        //保存文件信息
        SysOssEntity ossEntity = new SysOssEntity();
        ossEntity.setUrl(url);
        ossEntity.setCreateDate(new Date());
        sysOssService.save(ossEntity);

        JsonResult r = new JsonResult();
        r.put("url", url);
        r.put("link", url);
        return r;
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:oss:all")
    public JsonResult delete(@RequestBody Long[] ids) {
        sysOssService.deleteBatch(ids);

        return JsonResult.ok();
    }

    /**
     * 查询所有列表
     */
    @RequestMapping("/queryAll")
    public List<String> queryAll(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<SysOssEntity> sysOssList = sysOssService.queryList(params);

        List<String> list = new ArrayList<>();
        if (null != sysOssList && sysOssList.size() > 0) {
            for (SysOssEntity item : sysOssList) {
                list.add(item.getUrl());
            }
        }
        return list;
    }

}
