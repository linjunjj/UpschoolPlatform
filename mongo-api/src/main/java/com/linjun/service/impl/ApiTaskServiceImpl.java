package com.linjun.service.impl;

import com.linjun.dao.ApiTaskMapper;
import com.linjun.entity.TaskVo;
import com.linjun.service.ApiTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiTaskService")
public class ApiTaskServiceImpl implements ApiTaskService {
    @Autowired
    private ApiTaskMapper apiTaskMapper;
    @Override
    public TaskVo queryObject(Long id) {
        return apiTaskMapper.queryObject(id);
    }

    @Override
    public List<TaskVo> queryList(Map<String, Object> map) {
        return apiTaskMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiTaskMapper.queryTotal(map);
    }

    @Override
    public void save(TaskVo taskVo) {
  apiTaskMapper.save(taskVo);
    }

    @Override
    public void update(TaskVo taskVo) {
apiTaskMapper.update(taskVo);
    }

    @Override
    public void delete(Long id) {
apiTaskMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiTaskMapper.deleteBatch(ids);
    }
}
