package com.linjun.service.impl;

import com.linjun.dao.ApiShoppingMapper;
import com.linjun.entity.ShippingEntity;
import com.linjun.service.ApiShippingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
public class ApiShippingServiceImpl implements ApiShippingService {

    @Autowired
    private ApiShoppingMapper apiShoppingMapper;
    @Override
    public ShippingEntity queryObject(Long id) {
        return apiShoppingMapper.queryObject(id);
    }

    @Override
    public List<ShippingEntity> queryList(Map<String, Object> map) {
        return apiShoppingMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  apiShoppingMapper.queryTotal(map);
    }

    @Override
    public void save(ShippingEntity shippingEntity) {
     apiShoppingMapper.save(shippingEntity);
    }

    @Override
    public void update(ShippingEntity shippingEntity) {
    apiShoppingMapper.update(shippingEntity);
    }

    @Override
    public void delete(Long id) {
   apiShoppingMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
    apiShoppingMapper.deleteBatch(ids);
    }
}
