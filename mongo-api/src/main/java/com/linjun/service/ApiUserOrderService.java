package com.linjun.service;

import com.linjun.entity.UserOrderVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiUserOrderService {
    UserOrderVo queryObject(Long id);
    List<UserOrderVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserOrderVo userOrderVo);
    void update(UserOrderVo userOrderVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
