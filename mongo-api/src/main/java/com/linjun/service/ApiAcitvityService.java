package com.linjun.service;

import com.linjun.entity.ActivityVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ApiAcitvityService {
    ActivityVo queryObject(Long id);
    List<ActivityVo> queryList(Map<String,Object> map);
     int queryTotal(Map<String, Object> map);
     void save(ActivityVo activityVo);
     void update(ActivityVo activityVo);
     void  delete(Long id);
     void deleteBatch(Long[] ids);
}
