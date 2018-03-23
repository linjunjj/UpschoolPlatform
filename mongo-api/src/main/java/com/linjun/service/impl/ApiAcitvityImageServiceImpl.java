package com.linjun.service.impl;

import com.linjun.dao.ApiActivityImageMapper;
import com.linjun.entity.ActivityImageEntity;
import com.linjun.service.ApiAcitvityImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
public class ApiAcitvityImageServiceImpl implements ApiAcitvityImageService {
@Autowired
private ApiActivityImageMapper apiActivityImageMapper;
    @Override
    public ActivityImageEntity queryObject(Integer id) {
        return apiActivityImageMapper.queryObject(id);
    }

    @Override
    public List<ActivityImageEntity> queryList(Map<String, Object> map) {
        return apiActivityImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiActivityImageMapper.queryTotal(map);
    }

    @Override
    public void save(ActivityImageEntity activityImageEntity) {
        apiActivityImageMapper.save(activityImageEntity);
    }

    @Override
    public void update(ActivityImageEntity activityImageEntity) {
          apiActivityImageMapper.update(activityImageEntity);
    }

    @Override
    public void delete(Integer id) {
            apiActivityImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
           apiActivityImageMapper.deleteBatch(ids);
    }
}
