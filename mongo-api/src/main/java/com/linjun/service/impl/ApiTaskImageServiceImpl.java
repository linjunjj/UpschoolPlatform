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
    public TaskImageEntity queryObject(Long id) {
        return apiTaskImageMapper.queryObject(id);
    }

    @Override
    public List<TaskImageEntity> queryList(Map<String, Object> map) {
        return apiTaskImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiTaskImageMapper.queryTotal(map);
    }

    @Override
    public void save(TaskImageEntity taskImageEntity) {
 apiTaskImageMapper.save(taskImageEntity);
    }

    @Override
    public void update(TaskImageEntity taskImageEntity) {
  apiTaskImageMapper.update(taskImageEntity);
    }

    @Override
    public void delete(Long id) {
  apiTaskImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
 apiTaskImageMapper.deleteBatch(ids);
    }
}
