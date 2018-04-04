package com.linjun.service.impl;

import com.linjun.dao.UserDynamicMapper;
import com.linjun.entity.UserDynamicEntity;
import com.linjun.service.UserDynamicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
public class UserDynamicServiceImpl implements UserDynamicService {
    @Autowired
    private UserDynamicMapper userDynamicMapper;
    @Override
    public UserDynamicEntity queryObject(Long id) {
        return userDynamicMapper.queryObject(id);
    }

    @Override
    public List<UserDynamicEntity> queryList(Map<String, Object> map) {
        return userDynamicMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userDynamicMapper.queryTotal(map);
    }

    @Override
    public void save(UserDynamicEntity userDynamicEntity) {
      userDynamicMapper.save(userDynamicEntity);
    }

    @Override
    public void update(UserDynamicEntity userDynamicEntity) {
   userDynamicMapper.update(userDynamicEntity);
    }

    @Override
    public void delete(Long id) {
      userDynamicMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
     userDynamicMapper.deleteBatch(ids);
    }
}
