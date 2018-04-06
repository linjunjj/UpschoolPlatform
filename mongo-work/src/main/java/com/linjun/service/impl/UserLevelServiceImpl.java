package com.linjun.service.impl;

import com.linjun.dao.UserLevelMapper;
import com.linjun.entity.UserLevelEntity;
import com.linjun.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service("userLevelService")
public class UserLevelServiceImpl implements UserLevelService {
    @Autowired
    private UserLevelMapper userLevelMapper;
    @Override
    public UserLevelEntity queryObject(Long id) {
        return userLevelMapper.queryObject(id);
    }

    @Override
    public List<UserLevelEntity> queryList(Map<String, Object> map) {
        return userLevelMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userLevelMapper.queryTotal(map);
    }

    @Override
    public void save(UserLevelEntity userLevelEntity) {
   userLevelMapper.save(userLevelEntity);
    }

    @Override
    public void update(UserLevelEntity userLevelEntity) {
  userLevelMapper.update(userLevelEntity);
    }

    @Override
    public void delete(Long id) {
  userLevelMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  userLevelMapper.deleteBatch(ids);
    }
}
