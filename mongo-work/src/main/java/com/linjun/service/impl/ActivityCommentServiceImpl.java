package com.linjun.service.impl;

import com.linjun.dao.ActivityCommentMapper;
import com.linjun.entity.ActivityCommentEntity;
import com.linjun.service.ActivityCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service("activityCommentService")
public class ActivityCommentServiceImpl implements ActivityCommentService {
    @Autowired
    private ActivityCommentMapper activityCommentMapper;
    @Override
    public ActivityCommentEntity queryObject(Long id) {
        return activityCommentMapper.queryObject(id);
    }

    @Override
    public List<ActivityCommentEntity> queryList(Map<String, Object> map) {
        return activityCommentMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return activityCommentMapper.queryTotal(map);
    }

    @Override
    public void save(ActivityCommentEntity activityCommentEntity) {
activityCommentMapper.save(activityCommentEntity);
    }

    @Override
    public void update(ActivityCommentEntity activityCommentEntity) {
activityCommentMapper.update(activityCommentEntity);
    }

    @Override
    public void delete(Long id) {
activityCommentMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
activityCommentMapper.deleteBatch(ids);
    }
}
