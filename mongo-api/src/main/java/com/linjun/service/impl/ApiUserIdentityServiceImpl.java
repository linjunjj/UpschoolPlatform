package com.linjun.service.impl;

import com.linjun.dao.ApiUserIdentityMapper;
import com.linjun.entity.UserIdentityEntity;
import com.linjun.service.ApiUserIdentityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiUserIdentityServiceImpl implements ApiUserIdentityService {
    @Autowired
    private ApiUserIdentityMapper apiUserIdentityMapper;
    @Override
    public UserIdentityEntity queryObject(Long id) {
        return apiUserIdentityMapper.queryObject(id);
    }

    @Override
    public List<UserIdentityEntity> queryList(Map<String, Object> map) {
        return apiUserIdentityMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserIdentityMapper.queryTotal(map);
    }

    @Override
    public void save(UserIdentityEntity userIdentityEntity) {
   apiUserIdentityMapper.save(userIdentityEntity);
    }

    @Override
    public void update(UserIdentityEntity userIdentityEntity) {
apiUserIdentityMapper.update(userIdentityEntity);
    }

    @Override
    public void delete(Long id) {
 apiUserIdentityMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiUserIdentityMapper.deleteBatch(ids);
    }
}
