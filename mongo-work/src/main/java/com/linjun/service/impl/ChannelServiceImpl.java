package com.linjun.service.impl;

import com.linjun.dao.ChannelMapper;
import com.linjun.entity.ChannelEntity;
import com.linjun.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service("channelService")
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelMapper channelMapper;
    @Override
    public ChannelEntity queryObject(Long id) {
        return channelMapper.queryObject(id);
    }

    @Override
    public List<ChannelEntity> queryList(Map<String, Object> map) {
        return channelMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return channelMapper.queryTotal(map);
    }

    @Override
    public void save(ChannelEntity channelEntity) {
   channelMapper.save(channelEntity);
    }

    @Override
    public void update(ChannelEntity channelEntity) {
     channelMapper.update(channelEntity);
    }

    @Override
    public void delete(Long id) {
    channelMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
     channelMapper.deleteBatch(ids);
    }
}
