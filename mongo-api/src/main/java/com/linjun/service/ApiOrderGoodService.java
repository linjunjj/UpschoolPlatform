package com.linjun.service;

import com.linjun.entity.OrderGoodVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/

public interface ApiOrderGoodService  {
    OrderGoodVo queryObject(Long id);
    List<OrderGoodVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String ,Object> map);
    void save(OrderGoodVo orderGoodVo);
    void update(OrderGoodVo orderGoodVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
