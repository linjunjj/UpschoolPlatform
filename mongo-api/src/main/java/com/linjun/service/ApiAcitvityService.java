package com.linjun.service;

import com.linjun.entity.ActivityEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ApiAcitvityService {
    ActivityEntity queryObject(Long id);
    List<ActivityEntity> queryList(Map<String,Object> map);
     int queryTotal(Map<String, Object> map);
     void save(ActivityEntity activityEntity);
     void update(ActivityEntity activityEntity);
     void  delete(Long id);
     void deleteBatch(Long[] ids);
}
