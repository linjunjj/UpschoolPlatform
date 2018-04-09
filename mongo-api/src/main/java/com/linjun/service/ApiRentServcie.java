package com.linjun.service;

import com.linjun.entity.RentVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiRentServcie {
    RentVo queryObject(Long id);
    List<RentVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(RentVo rentVo);
    void update(RentVo rentVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
