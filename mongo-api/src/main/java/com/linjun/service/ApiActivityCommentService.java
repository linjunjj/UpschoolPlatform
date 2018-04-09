package com.linjun.service;

import com.linjun.entity.ActivityCommentVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ApiActivityCommentService {
    ActivityCommentVo queryObject(Long id);
    List<ActivityCommentVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(ActivityCommentVo activityCommentVo);
    void update(ActivityCommentVo activityCommentVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
