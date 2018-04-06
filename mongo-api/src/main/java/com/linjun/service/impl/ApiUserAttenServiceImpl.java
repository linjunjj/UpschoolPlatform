package com.linjun.service.impl;

import com.linjun.dao.ApiUserAttenMapper;
import com.linjun.entity.UserAttenEntity;
import com.linjun.service.ApiUserAttenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public class ApiUserAttenServiceImpl implements ApiUserAttenService {
    @Autowired
    private ApiUserAttenMapper apiUserAttenMapper;
    @Override
    public UserAttenEntity queryObject(Long id) {
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
    public void delete(Long id) {
apiUserAttenMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
 apiUserAttenMapper.deleteBatch(ids);
    }
}
