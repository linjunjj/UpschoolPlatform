package com.linjun.service.impl;

import com.linjun.dao.PartTimeMapper;
import com.linjun.entity.PartTimeEntity;
import com.linjun.service.PartTimeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
public class PartTimeServiceImpl implements PartTimeService {
    @Autowired
    private PartTimeMapper partTimeMapper;
    @Override
    public PartTimeEntity queryObject(Long id) {
        return partTimeMapper.queryObject(id);
    }

    @Override
    public List<PartTimeEntity> queryList(Map<String, Object> map) {
        return partTimeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return partTimeMapper.queryTotal(map);
    }

    @Override
    public void save(PartTimeEntity partTimeEntity) {
       partTimeMapper.save(partTimeEntity);
    }

    @Override
    public void update(PartTimeEntity partTimeEntity) {
  partTimeMapper.update(partTimeEntity);
    }

    @Override
    public void delete(Long id) {
    partTimeMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  partTimeMapper.deleteBatch(ids);
    }
}
