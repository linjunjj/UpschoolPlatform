package com.linjun.service;

import com.linjun.entity.PartTimeImageVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/

public interface ApiPartTimeImageService {
    PartTimeImageVo queryObject(Long id);
    List<PartTimeImageVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(PartTimeImageVo partTimeImageVo);
    void update(PartTimeImageVo partTimeImageVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
