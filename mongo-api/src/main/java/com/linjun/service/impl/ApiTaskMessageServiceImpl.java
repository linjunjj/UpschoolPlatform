package com.linjun.service.impl;

import com.linjun.dao.ApiTaskMessageMapper;
import com.linjun.entity.TaskMessageEntity;
import com.linjun.service.ApiTaskMessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiTaskMessageServiceImpl implements ApiTaskMessageService {
    @Autowired
    private ApiTaskMessageMapper apiTaskMessageMapper;
    @Override
    public TaskMessageEntity queryObject(Integer id) {
        return apiTaskMessageMapper.queryObject(id);
    }

    @Override
    public List<TaskMessageEntity> queryList(Map<String, Object> map) {
        return apiTaskMessageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiTaskMessageMapper.queryTotal(map);
    }

    @Override
    public void save(TaskMessageEntity taskMessageEntity) {
  apiTaskMessageMapper.save(taskMessageEntity);
    }

    @Override
    public void update(TaskMessageEntity taskMessageEntity) {
apiTaskMessageMapper.update(taskMessageEntity);
    }

    @Override
    public void delete(Integer id) {
apiTaskMessageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
apiTaskMessageMapper.deleteBatch(ids);
    }
}
