package com.linjun.service.impl;

import com.linjun.dao.UserAttenMapper;
import com.linjun.entity.UserAttenEntity;
import com.linjun.service.UserAttenService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
public class UserAttenServcieImpl implements UserAttenService {
    @Autowired
    private UserAttenMapper userAttenMapper;
    @Override
    public UserAttenEntity queryObject(Long id) {
        return userAttenMapper.queryObject(id);
    }

    @Override
    public List<UserAttenEntity> queryList(Map<String, Object> map) {
        return userAttenMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userAttenMapper.queryTotal(map);
    }

    @Override
    public void save(UserAttenEntity userAttenEntity) {
    userAttenMapper.save(userAttenEntity);
    }

    @Override
    public void update(UserAttenEntity userAttenEntity) {
   userAttenMapper.update(userAttenEntity);
    }

    @Override
    public void delete(Long id) {
   userAttenMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
    userAttenMapper.deleteBatch(ids);
    }
}
