package com.linjun.service.impl;

import com.linjun.dao.UserOrderMapper;
import com.linjun.entity.UserOrderEntity;
import com.linjun.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service("userOrderService")
public class UserOrderServiceImpl implements UserOrderService {
    @Autowired
    private UserOrderMapper userOrderMapper;
    @Override
    public UserOrderEntity queryObject(Long id) {
        return userOrderMapper.queryObject(id);
    }

    @Override
    public List<UserOrderEntity> queryList(Map<String, Object> map) {
        return userOrderMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userOrderMapper.queryTotal(map);
    }

    @Override
    public void save(UserOrderEntity userOrderEntity) {
  userOrderMapper.save(userOrderEntity);
    }

    @Override
    public void update(UserOrderEntity userOrderEntity) {
   userOrderMapper.update(userOrderEntity);
    }

    @Override
    public void delete(Long id) {
 userOrderMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  userOrderMapper.deleteBatch(ids);
    }
}
