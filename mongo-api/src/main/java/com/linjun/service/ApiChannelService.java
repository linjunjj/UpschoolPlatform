package com.linjun.service;

import com.linjun.entity.ChannelVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ApiChannelService {
    ChannelVo queryObject(Long id);
    List<ChannelVo>  queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(ChannelVo channelVo);
    void update(ChannelVo channelVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
