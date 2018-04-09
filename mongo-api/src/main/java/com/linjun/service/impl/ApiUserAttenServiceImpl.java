package com.linjun.service.impl;

import com.linjun.dao.ApiUserAttenMapper;
import com.linjun.entity.UserAttenVo;
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
@Service("apiUserAttenService")
public class ApiUserAttenServiceImpl implements ApiUserAttenService {
    @Autowired
    private ApiUserAttenMapper apiUserAttenMapper;
    @Override
    public UserAttenVo queryObject(Long id) {
        return apiUserAttenMapper.queryObject(id);
    }

    @Override
    public List<UserAttenVo> queryList(Map<String, Object> map) {
        return apiUserAttenMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserAttenMapper.queryTotal(map);
    }

    @Override
    public void save(UserAttenVo userAttenVo) {
 apiUserAttenMapper.save(userAttenVo);
    }

    @Override
    public void update(UserAttenVo userAttenVo) {
  apiUserAttenMapper.update(userAttenVo);
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
