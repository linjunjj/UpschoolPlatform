package com.linjun.service.impl;

import com.linjun.dao.ApiShoppingMapper;
import com.linjun.entity.ShippingVo;
import com.linjun.service.ApiShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service("apiShippingService")
public class ApiShippingServiceImpl implements ApiShippingService {

    @Autowired
    private ApiShoppingMapper apiShoppingMapper;
    @Override
    public ShippingVo queryObject(Long id) {
        return apiShoppingMapper.queryObject(id);
    }

    @Override
    public List<ShippingVo> queryList(Map<String, Object> map) {
        return apiShoppingMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  apiShoppingMapper.queryTotal(map);
    }

    @Override
    public void save(ShippingVo shippingVo) {
     apiShoppingMapper.save(shippingVo);
    }

    @Override
    public void update(ShippingVo shippingVo) {
    apiShoppingMapper.update(shippingVo);
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
