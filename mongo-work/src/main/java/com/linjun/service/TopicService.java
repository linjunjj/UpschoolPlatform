package com.linjun.service;

import com.linjun.entity.TopicEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/9/24.
 * @desc
 **/
public interface TopicService {
    TopicEntity queryObject(Long id);
    List<TopicEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(TopicEntity topicEntity);
    void update(TopicEntity topicEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
