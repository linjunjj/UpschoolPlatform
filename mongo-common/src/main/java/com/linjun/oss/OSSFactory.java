package com.linjun.oss;

import com.linjun.service.SysConfigService;
import com.linjun.utils.ConfigConstant;
import com.linjun.utils.Constant;
import com.linjun.utils.SpringContextUtils;

/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
public final class OSSFactory {
    private  static SysConfigService sysConfigService;
    static {
        OSSFactory.sysConfigService= (SysConfigService) SpringContextUtils.getBean("sysConfigService");
    }
    public  static  CloudStorageService build(){
        CloudStorageConfig config=sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY,CloudStorageConfig.class);
        if (config.getType()== Constant.CloudService.QINIU.getValue()){
            return new  Qiniu
        }
    }
}
