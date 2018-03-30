package com.linjun.dao;

import com.linjun.entity.SysMacroEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysMacroDao extends BaseDao<SysMacroEntity> {

    /**
     * 查询数据字段
     * @param value
     * @return
     */
    List<SysMacroEntity> queryMacrosByValue(@Param("value") String value);
}
