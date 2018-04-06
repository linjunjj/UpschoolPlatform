package com.linjun.service.impl;

import com.linjun.dao.TaskImageMapper;
import com.linjun.entity.TaskImageEntity;
import com.linjun.service.TaskImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service("taskImageService")
public class TaskImageServiceImpl implements TaskImageService {
    @Autowired
    private TaskImageMapper taskImageMapper;
    @Override
    public TaskImageEntity queryObject(Long id) {
        return taskImageMapper.queryObject(id);
    }

    @Override
    public List<TaskImageEntity> queryList(Map<String, Object> map) {
        return taskImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return taskImageMapper.queryTotal(map);
    }

    @Override
    public void save(TaskImageEntity taskImageEntity) {
    taskImageMapper.save(taskImageEntity);
    }

    @Override
    public void update(TaskImageEntity taskImageEntity) {
   taskImageMapper.update(taskImageEntity);
    }

    @Override
    public void delete(Long id) {
  taskImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   taskImageMapper.deleteBatch(ids);
    }
}
