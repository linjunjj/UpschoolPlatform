package com.linjun.service.impl;

import com.linjun.dao.ApiRentMapper;
import com.linjun.entity.RentEntity;
import com.linjun.service.ApiRentServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service("apiRentService")
public class ApiRentServiceImpl implements ApiRentServcie {
    @Autowired
    private ApiRentMapper apiRentMapper;
    @Override
    public RentEntity queryObject(Long id) {
        return apiRentMapper.queryObject(id);
    }

    @Override
    public List<RentEntity> queryList(Map<String, Object> map) {
        return apiRentMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiRentMapper.queryTotal(map);
    }

    @Override
    public void save(RentEntity rentEntity) {
       apiRentMapper.save(rentEntity);
    }

    @Override
    public void update(RentEntity rentEntity) {
    apiRentMapper.update(rentEntity);
    }

    @Override
    public void delete(Long id) {
         apiRentMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
    apiRentMapper.deleteBatch(ids);
    }
}
