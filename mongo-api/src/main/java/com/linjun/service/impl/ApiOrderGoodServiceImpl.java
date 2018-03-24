package com.linjun.service.impl;

import com.linjun.dao.ApiOrderGoodMapper;
import com.linjun.entity.OrderGoodEntity;
import com.linjun.service.ApiOrderGoodService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
public class ApiOrderGoodServiceImpl implements ApiOrderGoodService
{
    @Autowired
    private ApiOrderGoodMapper apiOrderGoodMapper;
    @Override
    public OrderGoodEntity queryObject(Integer id) {
        return apiOrderGoodMapper.queryObject(id);
    }

    @Override
    public List<OrderGoodEntity> queryList(Map<String, Object> map) {
        return apiOrderGoodMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiOrderGoodMapper.queryTotal(map);
    }

    @Override
    public void save(OrderGoodEntity orderGoodEntity) {
        apiOrderGoodMapper.save(orderGoodEntity);
    }

    @Override
    public void update(OrderGoodEntity orderGoodEntity) {
        apiOrderGoodMapper.update(orderGoodEntity);
    }

    @Override
    public void delete(Integer id) {
    apiOrderGoodMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
  apiOrderGoodMapper.deleteBatch(ids);
    }
}
