package com.linjun.service.impl;

import com.linjun.dao.DynamicCommentMapper;
import com.linjun.entity.DynamicCommentEntity;
import com.linjun.service.DynamicCommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
public class DynamicCommentServiceImpl implements DynamicCommentService {
    @Autowired
    private DynamicCommentMapper dynamicCommentMapper;
    @Override
    public DynamicCommentEntity queryObject(Long id) {
        return dynamicCommentMapper.queryObject(id);
    }

    @Override
    public List<DynamicCommentEntity> queryList(Map<String, Object> map) {
        return dynamicCommentMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return dynamicCommentMapper.queryTotal(map);
    }

    @Override
    public void save(DynamicCommentEntity dynamicCommentEntity) {
   dynamicCommentMapper.save(dynamicCommentEntity);
    }

    @Override
    public void update(DynamicCommentEntity dynamicCommentEntity) {
    dynamicCommentMapper.update(dynamicCommentEntity);
    }

    @Override
    public void delete(Long id) {
   dynamicCommentMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
    dynamicCommentMapper.deleteBatch(ids);
    }
}
