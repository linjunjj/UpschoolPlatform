package com.linjun.cache;

import com.linjun.dao.SysMacroDao;
import com.linjun.entity.SysMacroEntity;
import com.linjun.utils.SpringContextUtils;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.List;


public class CacheUtil implements InitializingBean {


    public static List<SysMacroEntity> sysMacroEntityList;

    public static void init() {
        SysMacroDao macroDao = SpringContextUtils.getBean(SysMacroDao.class);
        if (null != macroDao) {
            sysMacroEntityList = macroDao.queryList(new HashMap<String, Object>());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    /**
     * 根据字典标识获取字典中文
     *
     * @param value
     * @return
     */
    public static String getCodeName(String preName, String value) {
        String name = "";
        Long parentId = 0L;
        for (SysMacroEntity macroEntity : sysMacroEntityList) {
            if (value.equals(macroEntity.getValue())) {
                parentId = macroEntity.getParentId();
            }
        }
        for (SysMacroEntity macroEntity : sysMacroEntityList) {
            if (preName.equals(macroEntity.getValue()) && parentId.equals(macroEntity.getParentId())) {
                name = macroEntity.getName();
            }
        }
        return name;
    }

}