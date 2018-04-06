package com.linjun.service;

import com.linjun.entity.IdleCategroyEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/

public interface IdleCategoryService {
    IdleCategroyEntity queryObject(Long id);
    List<IdleCategroyEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(IdleCategroyEntity idleCategroyEntity);
    void update(IdleCategroyEntity idleCategroyEntity);
    void  delete(Long id);
    void deleteBatch(Long[] ids);
}
