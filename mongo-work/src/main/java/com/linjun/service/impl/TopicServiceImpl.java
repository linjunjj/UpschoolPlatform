package com.linjun.service.impl;

import com.linjun.dao.TopicMapper;
import com.linjun.entity.AdEntity;
import com.linjun.entity.TopicEntity;
import com.linjun.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/9/24.
 * @desc
 **/
@Service("topicService")
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;
    @Override
    public TopicEntity queryObject(Long id) {
        return topicMapper.queryObject(id);
    }

    @Override
    public List<TopicEntity> queryList(Map<String, Object> map) {
        return topicMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return topicMapper.queryTotal(map);
    }

    @Override
    public void save(TopicEntity adEntity) {
        topicMapper.save(adEntity);
    }

    @Override
    public void update(TopicEntity adEntity) {
        topicMapper.update(adEntity);
    }

    @Override
    public void delete(Long id) {
        topicMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        topicMapper.deleteBatch(ids);
    }
}
