package com.linjun.service;

import com.linjun.entity.TopicPostionEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/9/24.
 * @desc
 **/
public interface TopicPostionService {
    TopicPostionEntity queryObject(Long id);
    List<TopicPostionEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(TopicPostionEntity adPositionEntity);
    void update(TopicPostionEntity adPositionEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}