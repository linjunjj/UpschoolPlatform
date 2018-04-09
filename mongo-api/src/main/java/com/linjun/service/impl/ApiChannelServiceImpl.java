package com.linjun.service.impl;

import com.linjun.dao.ApiChannelMapper;
import com.linjun.entity.ChannelVo;
import com.linjun.service.ApiChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service("apiChannelService")
public class ApiChannelServiceImpl implements ApiChannelService {
    @Autowired
    private ApiChannelMapper apiChannelMapper;
    @Override
    public ChannelVo queryObject(Long id) {
        return apiChannelMapper.queryObject(id);
    }

    @Override
    public List<ChannelVo> queryList(Map<String, Object> map) {
        return apiChannelMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiChannelMapper.queryTotal(map);
    }

    @Override
    public void save(ChannelVo channelVo) {
      apiChannelMapper.save(channelVo);
    }

    @Override
    public void update(ChannelVo channelVo) {
        apiChannelMapper.update(channelVo);
    }

    @Override
    public void delete(Long id) {
    apiChannelMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        apiChannelMapper.deleteBatch(ids);
    }
}
