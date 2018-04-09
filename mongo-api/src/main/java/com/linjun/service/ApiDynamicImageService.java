package com.linjun.service;

import com.linjun.entity.DynamicImageVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/

public interface ApiDynamicImageService {
    DynamicImageVo queryObject(Long id);
    List<DynamicImageVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(DynamicImageVo dynamicImageVo);
    void update(DynamicImageVo dynamicImageVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
