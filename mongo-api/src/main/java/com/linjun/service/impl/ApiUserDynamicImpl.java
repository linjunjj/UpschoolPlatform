package com.linjun.service.impl;

import com.linjun.dao.ApiUserDynamicMapper;
import com.linjun.entity.UserDynamicVo;
import com.linjun.service.ApiUserDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiUserDynamic")
public class ApiUserDynamicImpl implements ApiUserDynamicService {
    @Autowired
    private ApiUserDynamicMapper apiUserDynamicMapper;
    @Override
    public UserDynamicVo queryObject(Long id) {
        return apiUserDynamicMapper.queryObject(id);
    }

    @Override
    public List<UserDynamicVo> queryList(Map<String, Object> map) {
        return apiUserDynamicMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserDynamicMapper.queryTotal(map);
    }

    @Override
    public void save(UserDynamicVo userDynamicVo) {
apiUserDynamicMapper.save(userDynamicVo);
    }

    @Override
    public void update(UserDynamicVo userDynamicVo) {
apiUserDynamicMapper.update(userDynamicVo);
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
