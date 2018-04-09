package com.linjun.service;

import com.linjun.entity.RentMessageVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiRentMessageService {
    RentMessageVo queryObject(Long id);
    List<RentMessageVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(RentMessageVo rentMessageVo);
    void update(RentMessageVo rentMessageVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
