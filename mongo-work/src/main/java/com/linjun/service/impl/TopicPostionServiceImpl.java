package com.linjun.service.impl;

import com.linjun.dao.AdPositionMapper;
import com.linjun.dao.TopicPositionMapper;
import com.linjun.entity.TopicPostionEntity;
import com.linjun.service.TopicPostionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/9/24.
 * @desc
 **/
@Service("topicPostionService")
public class TopicPostionServiceImpl implements TopicPostionService {
    @Autowired
    private TopicPositionMapper topicPositionMapper;
    @Override
    public TopicPostionEntity queryObject(Long id) {
        return topicPositionMapper.queryObject(id);
    }

    @Override
    public List<TopicPostionEntity> queryList(Map<String, Object> map) {
        return topicPositionMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return topicPositionMapper.queryTotal(map);
    }

    @Override
    public void save(TopicPostionEntity adPositionEntity) {
        topicPositionMapper.save(adPositionEntity);
    }

    @Override
    public void update(TopicPostionEntity adPositionEntity) {
    topicPositionMapper.update(adPositionEntity);
    }

    @Override
    public void delete(Long id) {
    topicPositionMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
topicPositionMapper.deleteBatch(ids);
    }
}
