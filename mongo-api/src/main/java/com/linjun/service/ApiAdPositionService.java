package com.linjun.service;

import com.linjun.entity.AdPositionVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ApiAdPositionService {
    AdPositionVo queryObject(Long id);
    List<AdPositionVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(AdPositionVo adPositionVo);
    void update(AdPositionVo adPositionVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
