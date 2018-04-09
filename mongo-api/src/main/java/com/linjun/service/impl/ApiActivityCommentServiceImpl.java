package com.linjun.service.impl;

import com.linjun.dao.ApiActivityCommentMapper;
import com.linjun.entity.ActivityCommentVo;
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
    public ActivityCommentVo queryObject(Long id) {
        return apiActivityCommentMapper.queryObject(id);
    }

    @Override
    public List<ActivityCommentVo> queryList(Map<String, Object> map) {
        return apiActivityCommentMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiActivityCommentMapper.queryTotal(map);
    }

    @Override
    public void save(ActivityCommentVo activityCommentVo) {
         apiActivityCommentMapper.save(activityCommentVo);
    }

    @Override
    public void update(ActivityCommentVo activityCommentVo) {
           apiActivityCommentMapper.update(activityCommentVo);
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
