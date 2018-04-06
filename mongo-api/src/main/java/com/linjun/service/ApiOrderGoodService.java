package com.linjun.service;

import com.linjun.entity.OrderGoodEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/

public interface ApiOrderGoodService  {
    OrderGoodEntity queryObject(Long id);
    List<OrderGoodEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String ,Object> map);
    void save(OrderGoodEntity orderGoodEntity);
    void update(OrderGoodEntity orderGoodEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
