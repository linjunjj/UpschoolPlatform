package com.linjun.service.impl;

import com.linjun.dao.ApiUserIdentityMapper;
import com.linjun.entity.UserIdentityVo;
import com.linjun.service.ApiUserIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiUserIdentityService")
public class ApiUserIdentityServiceImpl implements ApiUserIdentityService {
    @Autowired
    private ApiUserIdentityMapper apiUserIdentityMapper;
    @Override
    public UserIdentityVo queryObject(Long id) {
        return apiUserIdentityMapper.queryObject(id);
    }

    @Override
    public List<UserIdentityVo> queryList(Map<String, Object> map) {
        return apiUserIdentityMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserIdentityMapper.queryTotal(map);
    }

    @Override
    public void save(UserIdentityVo userIdentityVo) {
   apiUserIdentityMapper.save(userIdentityVo);
    }

    @Override
    public void update(UserIdentityVo userIdentityVo) {
apiUserIdentityMapper.update(userIdentityVo);
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
