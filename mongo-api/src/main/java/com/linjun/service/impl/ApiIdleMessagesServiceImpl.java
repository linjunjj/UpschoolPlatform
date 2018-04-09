package com.linjun.service.impl;

import com.linjun.dao.ApiIdleMessageMapper;
import com.linjun.entity.IdleMessageVo;
import com.linjun.service.ApiIdleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service("apiIdleMessagesService")
public class ApiIdleMessagesServiceImpl implements ApiIdleMessageService {
    @Autowired
    private ApiIdleMessageMapper apiIdleMessageMapper;
    @Override
    public IdleMessageVo queryObject(Long id) {
        return apiIdleMessageMapper.queryObject(id);
    }

    @Override
    public List<IdleMessageVo> queryList(Map<String, Object> map) {
        return apiIdleMessageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiIdleMessageMapper.queryTotal(map);
    }

    @Override
    public void save(IdleMessageVo idleMessageVo) {
        apiIdleMessageMapper.save(idleMessageVo);
    }

    @Override
    public void update(IdleMessageVo idleMessageVo) {
     apiIdleMessageMapper.update(idleMessageVo);
    }

    @Override
    public void delete(Long id) {
    apiIdleMessageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
     apiIdleMessageMapper.deleteBatch(ids);
    }
}
