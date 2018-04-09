package com.linjun.service;

import com.linjun.entity.RentImageVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiRentImageService {
    RentImageVo queryObject(Long id);
    List<RentImageVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(RentImageVo rentImageVo);
    void update(RentImageVo rentImageVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
