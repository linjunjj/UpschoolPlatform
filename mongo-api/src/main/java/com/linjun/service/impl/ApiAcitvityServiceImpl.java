package com.linjun.service.impl;

import com.linjun.dao.ApiActivityMapper;
import com.linjun.entity.ActivityEntity;
import com.linjun.service.ApiAcitvityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
public class ApiAcitvityServiceImpl implements ApiAcitvityService{
    @Autowired
    private ApiActivityMapper apiActivityMapper;
    @Override
    public ActivityEntity queryObject(Long id) {
        return apiActivityMapper.queryObject(id);
    }

    @Override
    public List<ActivityEntity> queryList(Map<String, Object> map) {
        return apiActivityMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiActivityMapper.queryTotal(map);
    }

    @Override
    public void save(ActivityEntity activityEntity) {
         apiActivityMapper.save(activityEntity);
    }

    @Override
    public void update(ActivityEntity activityEntity) {
      apiActivityMapper.update(activityEntity);
    }

    @Override
    public void delete(Long id) {
     apiActivityMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   apiActivityMapper.deleteBatch(ids);
    }
}
