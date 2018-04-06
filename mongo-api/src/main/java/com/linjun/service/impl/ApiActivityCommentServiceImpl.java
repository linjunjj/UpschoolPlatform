package com.linjun.service.impl;

import com.linjun.dao.ApiActivityCategoryMapper;
import com.linjun.dao.ApiActivityCommentMapper;
import com.linjun.entity.ActivityCommentEntity;
import com.linjun.service.ApiActivityCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service("apiActivityCommentService")
public class ApiActivityCommentServiceImpl implements ApiActivityCommentService {
    @Autowired
    private ApiActivityCommentMapper apiActivityCommentMapper;
    @Override
    public ActivityCommentEntity queryObject(Long id) {
        return apiActivityCommentMapper.queryObject(id);
    }

    @Override
    public List<ActivityCommentEntity> queryList(Map<String, Object> map) {
        return apiActivityCommentMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiActivityCommentMapper.queryTotal(map);
    }

    @Override
    public void save(ActivityCommentEntity activityCommentEntity) {
         apiActivityCommentMapper.save(activityCommentEntity);
    }

    @Override
    public void update(ActivityCommentEntity activityCommentEntity) {
           apiActivityCommentMapper.update(activityCommentEntity);
    }

    @Override
    public void delete(Long id) {
          apiActivityCommentMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        apiActivityCommentMapper.deleteBatch(ids);
    }
}
