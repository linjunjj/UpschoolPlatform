package com.linjun.service;

import com.linjun.entity.ChannelEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service
public interface ChannelService {
    ChannelEntity queryObject(Long id);
    List<ChannelEntity>  queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(ChannelEntity channelEntity);
    void update(ChannelEntity channelEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
