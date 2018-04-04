package com.linjun.service.impl;

import com.linjun.dao.ShoppingMapper;
import com.linjun.entity.ShippingEntity;
import com.linjun.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
public class ShippingServiceImpl implements ShippingService {
    @Autowired
    private ShoppingMapper shoppingMapper;

    @Override
    public ShippingEntity queryObject(Long id) {
        return  shoppingMapper.queryObject(id);

    }

    @Override
    public List<ShippingEntity> queryList(Map<String, Object> map) {
        return shoppingMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return   shoppingMapper.queryTotal(map);
    }

    @Override
    public void save(ShippingEntity shippingEntity) {
   shoppingMapper.save(shippingEntity);
    }

    @Override
    public void update(ShippingEntity shippingEntity) {
    shoppingMapper.update(shippingEntity);
    }

    @Override
    public void delete(Long id) {
  shoppingMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   shoppingMapper.deleteBatch(ids);
    }
}
