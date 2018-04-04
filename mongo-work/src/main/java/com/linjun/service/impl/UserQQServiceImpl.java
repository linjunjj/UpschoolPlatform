package com.linjun.service.impl;

import com.linjun.dao.UserQQMapper;
import com.linjun.entity.UserQQEntity;
import com.linjun.service.UserQQService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
public class UserQQServiceImpl implements UserQQService {
    @Autowired
    private UserQQMapper userQQMapper;
    @Override
    public UserQQEntity queryObject(Long id) {
        return userQQMapper.queryObject(id);
    }

    @Override
    public List<UserQQEntity> queryList(Map<String, Object> map) {
        return userQQMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userQQMapper.queryTotal(map);
    }

    @Override
    public void save(UserQQEntity userQQEntity) {
      userQQMapper.save(userQQEntity);
    }

    @Override
    public void update(UserQQEntity userQQEntity) {
  userQQMapper.update(userQQEntity);
    }

    @Override
    public void delete(Long id) {
  userQQMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
userQQMapper.deleteBatch(ids);
    }
}
