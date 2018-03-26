package com.linjun.service.impl;

import com.linjun.dao.ApiUserAttenMapper;
import com.linjun.entity.UserAttenEntity;
import com.linjun.service.ApiUserAttenService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiUserAttenServiceImpl implements ApiUserAttenService {
    @Autowired
    private ApiUserAttenMapper apiUserAttenMapper;
    @Override
    public UserAttenEntity queryObject(Integer id) {
        return apiUserAttenMapper.queryObject(id);
    }

    @Override
    public List<UserAttenEntity> queryList(Map<String, Object> map) {
        return apiUserAttenMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserAttenMapper.queryTotal(map);
    }

    @Override
    public void save(UserAttenEntity userAttenEntity) {
 apiUserAttenMapper.save(userAttenEntity);
    }

    @Override
    public void update(UserAttenEntity userAttenEntity) {
  apiUserAttenMapper.update(userAttenEntity);
    }

    @Override
    public void delete(Integer id) {
apiUserAttenMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
 apiUserAttenMapper.deleteBatch(ids);
    }
}
