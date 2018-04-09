package com.linjun.service;

import com.linjun.entity.IdleImagesVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/

public interface ApiIdleImageService {
    IdleImagesVo queryObject(Long id);
    List<IdleImagesVo> queryList(Map<String ,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(IdleImagesVo idleImagesVo);
    void update(IdleImagesVo idleImagesVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
