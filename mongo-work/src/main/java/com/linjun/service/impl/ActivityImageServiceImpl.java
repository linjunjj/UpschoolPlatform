package com.linjun.service.impl;

import com.linjun.dao.ActivityImageMapper;
import com.linjun.entity.ActivityImageEntity;
import com.linjun.service.AcitvityImageService;
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
public class ActivityImageServiceImpl implements AcitvityImageService {
    @Autowired
    private ActivityImageMapper activityImageMapper;

    @Override
    public ActivityImageEntity queryObject(Long id) {
        return activityImageMapper.queryObject(id);
    }

    @Override
    public List<ActivityImageEntity> queryList(Map<String, Object> map) {
        return activityImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return activityImageMapper.queryTotal(map);
    }

    @Override
    public void save(ActivityImageEntity activityImageEntity) {
     activityImageMapper.save(activityImageEntity);
    }

    @Override
    public void update(ActivityImageEntity activityImageEntity) {
    activityImageMapper.update(activityImageEntity);
    }

    @Override
    public void delete(Long id) {
   activityImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
activityImageMapper.deleteBatch(ids);
    }
}
