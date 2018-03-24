package com.linjun.service.impl;

import com.linjun.dao.ApiIdleRalateMapper;
import com.linjun.entity.IdleRalateEntity;
import com.linjun.service.ApiIdleRalateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
public class ApiIdleRalateServiceImpl implements ApiIdleRalateService{
    @Autowired
    private ApiIdleRalateMapper apiIdleRalateMapper;
    @Override
    public IdleRalateEntity queryObject(Integer id) {
        return apiIdleRalateMapper.queryObject(id);
    }

    @Override
    public List<IdleRalateEntity> queryList(Map<String, Object> map) {
        return apiIdleRalateMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiIdleRalateMapper.queryTotal(map);
    }

    @Override
    public void save(IdleRalateEntity idleRalateEntity) {
       apiIdleRalateMapper.save(idleRalateEntity);
    }

    @Override
    public void update(IdleRalateEntity idleRalateEntity) {
        apiIdleRalateMapper.update(idleRalateEntity);
    }

    @Override
    public void delete(Integer id) {
       apiIdleRalateMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
      apiIdleRalateMapper.deleteBatch(ids);
    }
}
