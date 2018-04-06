package com.linjun.service;

import com.linjun.entity.ShippingEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ShippingService {
    ShippingEntity queryObject(Long id);
    List<ShippingEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(ShippingEntity shippingEntity);
    void  update(ShippingEntity shippingEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
