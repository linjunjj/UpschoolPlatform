package com.linjun.service.impl;

import com.linjun.dao.RentMapper;
import com.linjun.entity.RentEntity;
import com.linjun.service.RentServcie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
public class RentServiceImpl implements RentServcie {
    @Autowired
    private RentMapper rentMapper;
    @Override
    public RentEntity queryObject(Long id) {
        return rentMapper.queryObject(id);
    }

    @Override
    public List<RentEntity> queryList(Map<String, Object> map) {
        return rentMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return rentMapper.queryTotal(map);
    }

    @Override
    public void save(RentEntity rentEntity) {
  rentMapper.save(rentEntity);
    }

    @Override
    public void update(RentEntity rentEntity) {
  rentMapper.update(rentEntity);
    }

    @Override
    public void delete(Long id) {
   rentMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  rentMapper.deleteBatch(ids);
    }
}
