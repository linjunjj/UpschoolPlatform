package com.linjun.service;

import com.linjun.entity.AdVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ApiAdService {
    AdVo queryObject(Long id);
    List<AdVo> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(AdVo adVo);
     void update(AdVo adVo);
     void delete(Long id);
    void deleteBatch(Long[] ids);

}
