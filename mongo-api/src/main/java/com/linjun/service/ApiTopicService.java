package com.linjun.service;

import com.linjun.entity.TopicVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/10/4.
 * @desc
 **/
public interface ApiTopicService {
    TopicVo queryObject(Long id);
    List<TopicVo> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(TopicVo topicEntity);
    void update(TopicVo topicEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
