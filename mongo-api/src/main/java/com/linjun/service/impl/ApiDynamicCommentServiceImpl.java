package com.linjun.service.impl;

import com.linjun.dao.ApiDynamicCommentMapper;
import com.linjun.entity.DynamicCommentEntity;
import com.linjun.service.ApiDynamicCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service
public class ApiDynamicCommentServiceImpl implements ApiDynamicCommentService{
    @Autowired
    private ApiDynamicCommentMapper apiDynamicCommentMapper;

    @Override
    public DynamicCommentEntity queryObject(Long id) {
        return apiDynamicCommentMapper.queryObject(id);
    }

    @Override
    public List<DynamicCommentEntity> queryList(Map<String, Object> map) {
        return apiDynamicCommentMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiDynamicCommentMapper.queryTotal(map);
    }

    @Override
    public void save(DynamicCommentEntity dynamicCommentEntity) {
       apiDynamicCommentMapper.save(dynamicCommentEntity);
    }

    @Override
    public void update(DynamicCommentEntity dynamicCommentEntity) {
      apiDynamicCommentMapper.update(dynamicCommentEntity);
    }

    @Override
    public void delete(Long id) {
     apiDynamicCommentMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
           apiDynamicCommentMapper.deleteBatch(ids);
    }
}
