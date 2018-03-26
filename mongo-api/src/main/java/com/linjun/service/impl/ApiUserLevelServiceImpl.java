package com.linjun.service.impl;

import com.linjun.dao.ApiUserLevelMapper;
import com.linjun.entity.UserLevelEntity;
import com.linjun.service.ApiUserLevelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiUserLevelServiceImpl implements ApiUserLevelService {
    @Autowired
    private ApiUserLevelMapper apiUserLevelMapper;
    @Override
    public UserLevelEntity queryObject(Integer id) {
        return apiUserLevelMapper.queryObject(id);
    }

    @Override
    public List<UserLevelEntity> queryList(Map<String, Object> map) {
        return apiUserLevelMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserLevelMapper.queryTotal(map);
    }

    @Override
    public void save(UserLevelEntity userLevelEntity) {
 apiUserLevelMapper.save(userLevelEntity);
    }

    @Override
    public void update(UserLevelEntity userLevelEntity) {
apiUserLevelMapper.update(userLevelEntity);
    }

    @Override
    public void delete(Integer id) {
apiUserLevelMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
apiUserLevelMapper.deleteBatch(ids);
    }
}
