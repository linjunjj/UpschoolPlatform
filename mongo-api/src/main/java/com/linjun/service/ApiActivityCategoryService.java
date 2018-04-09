package com.linjun.service;

import com.linjun.entity.ActivityCategoryVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ApiActivityCategoryService {
    ActivityCategoryVo queryObject(Long id);
    List<ActivityCategoryVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(ActivityCategoryVo activityCategoryVo);
    void update(ActivityCategoryVo activityCategoryVo);
    void delete(Long  id);
    void deleteBatch(Long[] ids);

}
