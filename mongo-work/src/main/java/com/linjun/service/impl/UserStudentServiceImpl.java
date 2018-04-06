package com.linjun.service.impl;

import com.linjun.dao.UserStudentCardMapper;
import com.linjun.entity.UserStudentCardEntity;
import com.linjun.service.UserStudentCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service("userStudentService")
public class UserStudentServiceImpl implements UserStudentCardService {
    @Autowired
    private UserStudentCardMapper userStudentCardMapper;
    @Override
    public UserStudentCardEntity queryObject(Long id) {
        return userStudentCardMapper.queryObject(id);
    }

    @Override
    public List<UserStudentCardEntity> queryList(Map<String, Object> map) {
        return userStudentCardMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userStudentCardMapper.queryTotal(map);
    }

    @Override
    public void save(UserStudentCardEntity userStudentCardEntity) {
  userStudentCardMapper.save(userStudentCardEntity);
    }

    @Override
    public void update(UserStudentCardEntity userStudentCardEntity) {
    userStudentCardMapper.update(userStudentCardEntity);
    }

    @Override
    public void delete(Long id) {
userStudentCardMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  userStudentCardMapper.deleteBatch(ids);
    }
}
