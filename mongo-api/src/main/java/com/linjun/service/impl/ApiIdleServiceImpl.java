package com.linjun.service.impl;

import com.linjun.dao.ApiIdleMapper;
import com.linjun.entity.IdleEntity;
import com.linjun.service.ApiIdleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
public class ApiIdleServiceImpl implements ApiIdleService {
    @Autowired
    private ApiIdleMapper apiIdleMapper;
    @Override
    public IdleEntity queryObject(Long id) {
        return apiIdleMapper.queryObject(id);
    }

    @Override
    public List<IdleEntity> queryList(Map<String, Object> map) {
        return apiIdleMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  apiIdleMapper.queryTotal(map);
    }

    @Override
    public void save(IdleEntity idleEntity) {
         apiIdleMapper.save(idleEntity);
    }

    @Override
    public void update(IdleEntity idleEntity) {
         apiIdleMapper.update(idleEntity);
    }

    @Override
    public void delete(Long id) {
       apiIdleMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
      apiIdleMapper.deleteBatch(ids);
    }
}
