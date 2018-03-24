package com.linjun.service.impl;

import com.linjun.dao.ApiIdleCategoryMapper;
import com.linjun.entity.IdleCategroyEntity;
import com.linjun.service.ApiIdleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
public class ApiIdleCategoryServiceImpl implements ApiIdleCategoryService {
    @Autowired
    private ApiIdleCategoryMapper apiIdleCategoryMapper;
    @Override
    public IdleCategroyEntity queryObject(Integer id) {
        return apiIdleCategoryMapper.queryObject(id);
    }

    @Override
    public List<IdleCategroyEntity> queryList(Map<String, Object> map) {
        return apiIdleCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiIdleCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(IdleCategroyEntity idleCategroyEntity) {
          apiIdleCategoryMapper.save(idleCategroyEntity);
    }

    @Override
    public void update(IdleCategroyEntity idleCategroyEntity) {
         apiIdleCategoryMapper.update(idleCategroyEntity);
    }

    @Override
    public void delete(Integer id) {
      apiIdleCategoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        apiIdleCategoryMapper.deleteBatch(ids);
    }
}
