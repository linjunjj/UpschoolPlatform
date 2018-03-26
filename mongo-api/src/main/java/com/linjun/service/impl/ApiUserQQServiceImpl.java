package com.linjun.service.impl;

import com.linjun.dao.ApiUserQQMapper;
import com.linjun.entity.UserQQEntity;
import com.linjun.service.ApiUserQQService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiUserQQServiceImpl implements ApiUserQQService {
    @Autowired
    private ApiUserQQMapper apiUserQQMapper;
    @Override
    public UserQQEntity queryObject(Integer id) {
        return apiUserQQMapper.queryObject(id);
    }

    @Override
    public List<UserQQEntity> queryList(Map<String, Object> map) {
        return apiUserQQMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserQQMapper.queryTotal(map);
    }

    @Override
    public void save(UserQQEntity userQQEntity) {
  apiUserQQMapper.save(userQQEntity);
    }

    @Override
    public void update(UserQQEntity userQQEntity) {
apiUserQQMapper.update(userQQEntity);
    }

    @Override
    public void delete(Integer id) {
apiUserQQMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
  apiUserQQMapper.deleteBatch(ids);
    }
}
