package com.linjun.service.impl;

import com.linjun.dao.OrderGoodMapper;
import com.linjun.entity.OrderGoodEntity;
import com.linjun.service.OrderGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service
public class OrderGoodsServiceImpl implements OrderGoodService {
    @Autowired
    private OrderGoodMapper orderGoodMapper;
    @Override
    public OrderGoodEntity queryObject(Long id) {
        return orderGoodMapper.queryObject(id);
    }

    @Override
    public List<OrderGoodEntity> queryList(Map<String, Object> map) {
        return orderGoodMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  orderGoodMapper.queryTotal(map);
    }

    @Override
    public void save(OrderGoodEntity orderGoodEntity) {
  orderGoodMapper.save(orderGoodEntity);
    }

    @Override
    public void update(OrderGoodEntity orderGoodEntity) {
   orderGoodMapper.update(orderGoodEntity);
    }

    @Override
    public void delete(Long id) {
    orderGoodMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  orderGoodMapper.deleteBatch(ids);
    }
}
