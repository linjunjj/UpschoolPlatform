package com.linjun.service.impl;

import com.linjun.dao.UserIncomeMapper;
import com.linjun.entity.UserIncomeEntity;
import com.linjun.service.UserIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service("userIncomeService")
public class UserIncomeServiceImpl implements UserIncomeService {
    @Autowired
    private UserIncomeMapper userIncomeMapper;
    @Override
    public UserIncomeEntity queryObject(Long id) {
        return userIncomeMapper.queryObject(id);
    }

    @Override
    public List<UserIncomeEntity> queryList(Map<String, Object> map) {
        return userIncomeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userIncomeMapper.queryTotal(map);
    }

    @Override
    public void save(UserIncomeEntity userIncomeEntity) {
    userIncomeMapper.save(userIncomeEntity);
    }

    @Override
    public void update(UserIncomeEntity userIncomeEntity) {
   userIncomeMapper.update(userIncomeEntity);
    }

    @Override
    public void delete(Long id) {
  userIncomeMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  userIncomeMapper.deleteBatch(ids);
    }
}
