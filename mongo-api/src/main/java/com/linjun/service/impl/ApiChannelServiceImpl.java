package com.linjun.service.impl;

import com.linjun.dao.ApiChannelMapper;
import com.linjun.entity.ChannelEntity;
import com.linjun.service.ApiChannelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
public class ApiChannelServiceImpl implements ApiChannelService {
    @Autowired
    private ApiChannelMapper apiChannelMapper;
    @Override
    public ChannelEntity queryObject(Integer id) {
        return apiChannelMapper.queryObject(id);
    }

    @Override
    public List<ChannelEntity> queryList(Map<String, Object> map) {
        return apiChannelMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiChannelMapper.queryTotal(map);
    }

    @Override
    public void save(ChannelEntity channelEntity) {
      apiChannelMapper.save(channelEntity);
    }

    @Override
    public void update(ChannelEntity channelEntity) {
        apiChannelMapper.update(channelEntity);
    }

    @Override
    public void delete(Integer id) {
    apiChannelMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        apiChannelMapper.deleteBatch(ids);
    }
}