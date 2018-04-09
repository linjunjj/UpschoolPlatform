package com.linjun.service.impl;

import com.linjun.dao.ApiTaskLabelMapper;
import com.linjun.entity.TaskLabelVo;
import com.linjun.service.ApiTaskLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiTaskLabelService")
public class ApiTaskLabelServiceImpl implements ApiTaskLabelService {
    @Autowired
    private ApiTaskLabelMapper apiTaskLabelMapper;
    @Override
    public TaskLabelVo queryObject(Long id) {
        return apiTaskLabelMapper.queryObject(id);
    }

    @Override
    public List<TaskLabelVo> queryList(Map<String, Object> map) {
        return apiTaskLabelMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiTaskLabelMapper.queryTotal(map);
    }

    @Override
    public void save(TaskLabelVo taskLabelVo) {
apiTaskLabelMapper.save(taskLabelVo);
    }

    @Override
    public void update(TaskLabelVo taskLabelVo) {
apiTaskLabelMapper.update(taskLabelVo);
    }

    @Override
    public void delete(Long id) {
apiTaskLabelMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiTaskLabelMapper.deleteBatch(ids);
    }
}
