package com.linjun.service.impl;

import com.linjun.dao.ApiPartTimeMapper;
import com.linjun.entity.PartTimeEntity;
import com.linjun.service.ApiPartTimeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
public class ApiPartTimeServiceImpl implements ApiPartTimeService {
    @Autowired
    private ApiPartTimeMapper apiPartTimeMapper;
    @Override
    public PartTimeEntity queryObject(Integer id) {
        return apiPartTimeMapper.queryObject(id);
    }

    @Override
    public List<PartTimeEntity> queryList(Map<String, Object> map) {
        return apiPartTimeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiPartTimeMapper.queryTotal(map);
    }

    @Override
    public void save(PartTimeEntity partTimeEntity) {
    apiPartTimeMapper.save(partTimeEntity);
    }

    @Override
    public void update(PartTimeEntity partTimeEntity) {
   apiPartTimeMapper.update(partTimeEntity);
    }

    @Override
    public void delete(Integer id) {
    apiPartTimeMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
  apiPartTimeMapper.deleteBatch(ids);
    }
}
