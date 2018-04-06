package com.linjun.service.impl;

import com.linjun.dao.ActivityMapper;
import com.linjun.entity.ActivityEntity;
import com.linjun.service.AcitvityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service
public class ActivityServiceImpl implements AcitvityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public ActivityEntity queryObject(Long id) {
        return activityMapper.queryObject(id);
    }

    @Override
    public List<ActivityEntity> queryList(Map<String, Object> map) {
        return activityMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return activityMapper.queryTotal(map);
    }

    @Override
    public void save(ActivityEntity activityEntity) {
    activityMapper.save(activityEntity);
    }

    @Override
    public void update(ActivityEntity activityEntity) {
activityMapper.update(activityEntity);
    }

    @Override
    public void delete(Long id) {
activityMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
activityMapper.deleteBatch(ids);
    }
}
