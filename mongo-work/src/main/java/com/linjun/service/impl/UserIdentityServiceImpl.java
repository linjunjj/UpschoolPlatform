package com.linjun.service.impl;

import com.linjun.dao.UserIdentityMapper;
import com.linjun.entity.UserIdentityEntity;
import com.linjun.service.UserIdentityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
public class UserIdentityServiceImpl implements UserIdentityService {
    @Autowired
    private UserIdentityMapper userIdentityMapper;
    @Override
    public UserIdentityEntity queryObject(Long id) {
        return userIdentityMapper.queryObject(id);
    }

    @Override
    public List<UserIdentityEntity> queryList(Map<String, Object> map) {
        return userIdentityMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userIdentityMapper.queryTotal(map);
    }

    @Override
    public void save(UserIdentityEntity userIdentityEntity) {
   userIdentityMapper.save(userIdentityEntity);
    }

    @Override
    public void update(UserIdentityEntity userIdentityEntity) {
  userIdentityMapper.update(userIdentityEntity);
    }

    @Override
    public void delete(Long id) {
  userIdentityMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
 userIdentityMapper.deleteBatch(ids);
    }
}
