package com.linjun.service.impl;

import com.linjun.dao.ApiTopicPositionMapper;
import com.linjun.entity.TopicPostionVo;
import com.linjun.service.ApiTopicPostionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/10/4.
 * @desc
 **/
@Service("apiTopicPositionService")
public class ApiTopicPositionServiceImpl implements ApiTopicPostionService {
    @Autowired
    private ApiTopicPositionMapper apiTopicPositionMapper;
    @Override
    public TopicPostionVo queryObject(Long id) {
        return apiTopicPositionMapper.queryObject(id);
    }

    @Override
    public List<TopicPostionVo> queryList(Map<String, Object> map) {
        return apiTopicPositionMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiTopicPositionMapper.queryTotal(map);
    }

    @Override
    public void save(TopicPostionVo topicPostionVo) {
      apiTopicPositionMapper.save(topicPostionVo);
    }

    @Override
    public void update(TopicPostionVo topicPostionVo) {
      apiTopicPositionMapper.update(topicPostionVo);
    }

    @Override
    public void delete(Long id) {
      apiTopicPositionMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
      apiTopicPositionMapper.deleteBatch(ids);
    }
}
