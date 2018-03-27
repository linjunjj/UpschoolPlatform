package com.linjun.service;

import com.linjun.entity.UserOrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface ApiUserOrderService {
    UserOrderEntity  queryObject(Long id);
    List<UserOrderEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserOrderEntity userOrderEntity);
    void update(UserOrderEntity userOrderEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
