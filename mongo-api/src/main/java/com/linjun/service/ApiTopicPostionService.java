package com.linjun.service;

import com.linjun.entity.TopicPostionVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/10/4.
 * @desc
 **/
public interface ApiTopicPostionService {
    TopicPostionVo queryObject(Long id);
    List<TopicPostionVo> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(TopicPostionVo topicPostionVo);
    void update(TopicPostionVo topicPostionVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
