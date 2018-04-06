package com.linjun.service.impl;

import com.linjun.dao.TaskLabelMapper;
import com.linjun.entity.TaskLabelEntity;
import com.linjun.service.TaskLabelService;
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
public class TaskLabelServiceImpl implements TaskLabelService {
    @Autowired
    private TaskLabelMapper taskLabelMapper;
    @Override
    public TaskLabelEntity queryObject(Long id) {
        return taskLabelMapper.queryObject(id);
    }

    @Override
    public List<TaskLabelEntity> queryList(Map<String, Object> map) {
        return taskLabelMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return taskLabelMapper.queryTotal(map);
    }

    @Override
    public void save(TaskLabelEntity taskLabelEntity) {
    taskLabelMapper.save(taskLabelEntity);
    }

    @Override
    public void update(TaskLabelEntity taskLabelEntity) {
     taskLabelMapper.update(taskLabelEntity);
    }

    @Override
    public void delete(Long id) {
    taskLabelMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   taskLabelMapper.deleteBatch(ids);
    }
}
