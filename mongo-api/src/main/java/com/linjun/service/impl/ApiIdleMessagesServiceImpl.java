package com.linjun.service.impl;

import com.linjun.dao.ApiIdleMessageMapper;
import com.linjun.entity.IdleMessageEntity;
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
@Service
public class ApiIdleMessagesServiceImpl implements ApiIdleMessageService {
    @Autowired
    private ApiIdleMessageMapper apiIdleMessageMapper;
    @Override
    public IdleMessageEntity queryObject(Long id) {
        return apiIdleMessageMapper.queryObject(id);
    }

    @Override
    public List<IdleMessageEntity> queryList(Map<String, Object> map) {
        return apiIdleMessageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiIdleMessageMapper.queryTotal(map);
    }

    @Override
    public void save(IdleMessageEntity idleMessageEntity) {
        apiIdleMessageMapper.save(idleMessageEntity);
    }

    @Override
    public void update(IdleMessageEntity idleMessageEntity) {
     apiIdleMessageMapper.update(idleMessageEntity);
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
