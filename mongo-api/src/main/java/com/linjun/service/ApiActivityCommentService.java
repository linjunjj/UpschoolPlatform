package com.linjun.service;

import com.linjun.entity.ActivityCommentEntity;
import com.linjun.entity.ActivityImageEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service
public interface ApiActivityCommentService {
    ActivityCommentEntity queryObject(Long id);
    List<ActivityCommentEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(ActivityCommentEntity activityCommentEntity);
    void update(ActivityCommentEntity activityCommentEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
