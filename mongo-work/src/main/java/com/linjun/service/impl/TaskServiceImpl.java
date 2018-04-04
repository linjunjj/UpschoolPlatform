package com.linjun.service.impl;

import com.linjun.dao.TaskMapper;
import com.linjun.entity.TaskEntity;
import com.linjun.entity.TaskMessageEntity;
import com.linjun.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public TaskEntity queryObject(Long id) {
        return taskMapper.queryObject(id);
    }

    @Override
    public List<TaskEntity> queryList(Map<String, Object> map) {
        return taskMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return taskMapper.queryTotal(map);
    }

    @Override
    public void save(TaskEntity taskEntity) {
      taskMapper.save(taskEntity);
    }

    @Override
    public void update(TaskEntity taskEntity) {
   taskMapper.update(taskEntity);
    }

    @Override
    public void delete(Long id) {
      taskMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   taskMapper.deleteBatch(ids);
    }
}
