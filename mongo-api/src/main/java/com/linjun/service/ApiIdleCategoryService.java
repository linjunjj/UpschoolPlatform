package com.linjun.service;

import com.linjun.entity.IdleCategroyVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/

public interface ApiIdleCategoryService {
    IdleCategroyVo queryObject(Long id);
    List<IdleCategroyVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(IdleCategroyVo idleCategroyVo);
    void update(IdleCategroyVo idleCategroyVo);
    void  delete(Long id);
    void deleteBatch(Long[] ids);
}
