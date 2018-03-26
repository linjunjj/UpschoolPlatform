package com.linjun.service.impl;

import com.linjun.dao.ApiUserMapper;
import com.linjun.entity.UserEntity;
import com.linjun.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiUserServiceImpl implements ApiUserService {
    @Autowired
    private ApiUserMapper apiUserMapper;
    @Override
    public UserEntity queryObject(Integer id) {
        return apiUserMapper.queryObject(id);
    }

    @Override
    public List<UserEntity> queryList(Map<String, Object> map) {
        return apiUserMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserMapper.queryTotal(map);
    }

    @Override
    public void save(UserEntity userEntity) {
apiUserMapper.save(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
apiUserMapper.update(userEntity);
    }

    @Override
    public void delete(Integer id) {
apiUserMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
apiUserMapper.deleteBatch(ids);
    }
}
