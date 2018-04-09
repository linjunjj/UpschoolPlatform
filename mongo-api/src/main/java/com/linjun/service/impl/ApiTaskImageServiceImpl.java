package com.linjun.service.impl;

import com.linjun.dao.ApiTaskImageMapper;
import com.linjun.entity.TaskImageVo;
import com.linjun.service.ApiTaskImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiTaskImageService")
public class ApiTaskImageServiceImpl implements ApiTaskImageService {
    @Autowired
    private ApiTaskImageMapper apiTaskImageMapper;
    @Override
    public TaskImageVo queryObject(Long id) {
        return apiTaskImageMapper.queryObject(id);
    }

    @Override
    public List<TaskImageVo> queryList(Map<String, Object> map) {
        return apiTaskImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiTaskImageMapper.queryTotal(map);
    }

    @Override
    public void save(TaskImageVo taskImageVo) {
 apiTaskImageMapper.save(taskImageVo);
    }

    @Override
    public void update(TaskImageVo taskImageVo) {
  apiTaskImageMapper.update(taskImageVo);
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
