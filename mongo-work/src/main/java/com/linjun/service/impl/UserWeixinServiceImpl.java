package com.linjun.service.impl;

import com.linjun.dao.UserWeixinMapper;
import com.linjun.entity.UserWeixinEntity;
import com.linjun.service.UserWeixinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service
public class UserWeixinServiceImpl implements UserWeixinService {
    @Autowired
    private UserWeixinMapper userWeixinMapper;
    @Override
    public UserWeixinEntity queryObject(Long id) {
        return userWeixinMapper.queryObject(id);
    }

    @Override
    public List<UserWeixinEntity> queryList(Map<String, Object> map) {
        return userWeixinMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userWeixinMapper.queryTotal(map);
    }

    @Override
    public void save(UserWeixinEntity userWeixinEntity) {
  userWeixinMapper.save(userWeixinEntity);
    }

    @Override
    public void update(UserWeixinEntity userWeixinEntity) {
 userWeixinMapper.update(userWeixinEntity);
    }

    @Override
    public void delete(Long id) {
userWeixinMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
userWeixinMapper.deleteBatch(ids);
    }
}
