package com.linjun.service;

import com.linjun.entity.ActivityImageEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ApiAcitvityImageService {
    ActivityImageEntity queryObject(Long id);
    List<ActivityImageEntity> queryList(Map<String ,Object> map);
    int queryTotal(Map<String ,Object> map);
    void  save(ActivityImageEntity activityImageEntity);
    void update(ActivityImageEntity activityImageEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}