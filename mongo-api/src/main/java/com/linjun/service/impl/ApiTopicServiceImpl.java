package com.linjun.service.impl;

import com.linjun.dao.ApiTopicMapper;
import com.linjun.entity.TopicVo;
import com.linjun.service.ApiTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/10/4.
 * @desc
 **/
@Service("apiTopicService")
public class ApiTopicServiceImpl implements ApiTopicService {
    @Autowired
    private ApiTopicMapper apiTopicMapper;
    @Override
    public TopicVo queryObject(Long id) {
        return apiTopicMapper.queryObject(id);
    }

    @Override
    public List<TopicVo> queryList(Map<String, Object> map) {
        return apiTopicMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiTopicMapper.queryTotal(map);
    }

    @Override
    public void save(TopicVo topicEntity) {
        apiTopicMapper.save(topicEntity);
    }

    @Override
    public void update(TopicVo topicEntity) {
        apiTopicMapper.update(topicEntity);
    }

    @Override
    public void delete(Long id) {
     apiTopicMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        apiTopicMapper.deleteBatch(ids);
    }
}
