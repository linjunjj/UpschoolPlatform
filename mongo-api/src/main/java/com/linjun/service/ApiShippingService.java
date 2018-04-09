package com.linjun.service;

import com.linjun.entity.ShippingVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiShippingService {
    ShippingVo queryObject(Long id);
    List<ShippingVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(ShippingVo shippingVo);
    void  update(ShippingVo shippingVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
