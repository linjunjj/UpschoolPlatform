package com.linjun.service.impl;

import com.linjun.dao.ApiUserWeixinMapper;
import com.linjun.entity.UserWeixinEntity;
import com.linjun.service.ApiUserWeixinService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiUserWeixinServiceImpl implements ApiUserWeixinService {

    @Autowired
    private ApiUserWeixinMapper apiUserWeixinMapper;
    @Override
    public UserWeixinEntity queryObject(Long id) {
        return apiUserWeixinMapper.queryObject(id);
    }

    @Override
    public List<UserWeixinEntity> queryList(Map<String, Object> map) {
        return apiUserWeixinMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserWeixinMapper.queryTotal(map);
    }

    @Override
    public void save(UserWeixinEntity userWeixinEntity) {
 apiUserWeixinMapper.save(userWeixinEntity);
    }

    @Override
    public void update(UserWeixinEntity userWeixinEntity) {
apiUserWeixinMapper.update(userWeixinEntity);
    }

    @Override
    public void delete(Long id) {
apiUserWeixinMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiUserWeixinMapper.deleteBatch(ids);
    }
}
