package com.linjun.service;

import com.linjun.entity.ActivityImageVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ApiAcitvityImageService {
    ActivityImageVo queryObject(Long id);
    List<ActivityImageVo> queryList(Map<String ,Object> map);
    int queryTotal(Map<String ,Object> map);
    void  save(ActivityImageVo activityImageVo);
    void update(ActivityImageVo activityImageVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}