package com.linjun.service.impl;

import com.linjun.dao.ApiTaskImageMapper;
import com.linjun.entity.TaskImageEntity;
import com.linjun.service.ApiTaskImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiTaskImageServiceImpl implements ApiTaskImageService {
    @Autowired
    private ApiTaskImageMapper apiTaskImageMapper;
    @Override
    public TaskImageEntity queryObject(Integer id) {
        return apiTaskImageMapper.queryObject(id);
    }

    @Override
    public List<TaskImageEntity> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(TaskImageEntity taskImageEntity) {

    }

    @Override
    public void update(TaskImageEntity taskImageEntity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteBatch(Integer[] ids) {

    }
}
