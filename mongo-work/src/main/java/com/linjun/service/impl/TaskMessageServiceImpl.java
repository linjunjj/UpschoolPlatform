package com.linjun.service.impl;

import com.linjun.dao.TaskMessageMapper;
import com.linjun.entity.TaskMessageEntity;
import com.linjun.service.TaskMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service
public class TaskMessageServiceImpl implements TaskMessageService {
    @Autowired
    private TaskMessageMapper taskMessageMapper;
    @Override
    public TaskMessageEntity queryObject(Long id) {
        return taskMessageMapper.queryObject(id);
    }

    @Override
    public List<TaskMessageEntity> queryList(Map<String, Object> map) {
        return taskMessageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return taskMessageMapper.queryTotal(map);
    }

    @Override
    public void save(TaskMessageEntity taskMessageEntity) {
    taskMessageMapper.save(taskMessageEntity);
    }

    @Override
    public void update(TaskMessageEntity taskMessageEntity) {
    taskMessageMapper.update(taskMessageEntity);
    }

    @Override
    public void delete(Long id) {
    taskMessageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   taskMessageMapper.deleteBatch(ids);
    }
}
