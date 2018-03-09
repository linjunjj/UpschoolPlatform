package com.linjun.cache;

import com.linjun.dao.SysRegionDao;
import com.linjun.entity.SysRegionEntity;
import com.linjun.utils.SpringContextUtils;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.List;

public class RegionCacheUtil implements InitializingBean {
    public  static List<SysRegionEntity>  sysRegionEntityList;
    @Override
    public void afterPropertiesSet() throws Exception {
        SysRegionDao regionDao = SpringContextUtils.getBean(SysRegionDao.class);
        if (null != regionDao) {
            sysRegionEntityList = regionDao.queryList(new HashMap<String, Object>());
        }
    }
}
