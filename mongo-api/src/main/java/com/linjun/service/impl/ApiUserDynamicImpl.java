package com.linjun.service.impl;

import com.linjun.dao.ApiUserDynamicMapper;
import com.linjun.entity.UserDynamicEntity;
import com.linjun.service.ApiUserDynamicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiUserDynamicImpl implements ApiUserDynamicService {
    @Autowired
    private ApiUserDynamicMapper apiUserDynamicMapper;
    @Override
    public UserDynamicEntity queryObject(Long id) {
        return apiUserDynamicMapper.queryObject(id);
    }

    @Override
    public List<UserDynamicEntity> queryList(Map<String, Object> map) {
        return apiUserDynamicMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserDynamicMapper.queryTotal(map);
    }

    @Override
    public void save(UserDynamicEntity userDynamicEntity) {
apiUserDynamicMapper.save(userDynamicEntity);
    }

    @Override
    public void update(UserDynamicEntity userDynamicEntity) {
apiUserDynamicMapper.update(userDynamicEntity);
    }

    @Override
    public void delete(Long id) {
 apiUserDynamicMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiUserDynamicMapper.deleteBatch(ids);
    }
}
