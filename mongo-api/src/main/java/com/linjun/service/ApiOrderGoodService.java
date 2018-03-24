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
@Service
public interface ApiOrderGoodService  {
    OrderGoodEntity queryObject(Integer id);
    List<OrderGoodEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String ,Object> map);
    void save(OrderGoodEntity orderGoodEntity);
    void update(OrderGoodEntity orderGoodEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);

}
