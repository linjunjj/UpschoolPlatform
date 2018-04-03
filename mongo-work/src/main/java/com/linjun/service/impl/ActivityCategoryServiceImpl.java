package com.linjun.service.impl;

import com.linjun.dao.ActivityCategoryMapper;
import com.linjun.entity.ActivityCategoryEntity;
import com.linjun.service.ActivityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
public class ActivityCategoryServiceImpl implements ActivityCategoryService {
    @Autowired
    private ActivityCategoryMapper activityCategoryMapper;
    @Override
    public ActivityCategoryEntity queryObject(Long id) {
        return activityCategoryMapper.queryObject(id);
    }

    @Override
    public List<ActivityCategoryEntity> queryList(Map<String, Object> map) {
        return activityCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return activityCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(ActivityCategoryEntity activityCategoryEntity) {
   activityCategoryMapper.save(activityCategoryEntity);
    }

    @Override
    public void update(ActivityCategoryEntity activityCategoryEntity) {
   activityCategoryMapper.update(activityCategoryEntity);
    }

    @Override
    public void delete(Long id) {
activityCategoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
activityCategoryMapper.deleteBatch(ids);
    }
}
