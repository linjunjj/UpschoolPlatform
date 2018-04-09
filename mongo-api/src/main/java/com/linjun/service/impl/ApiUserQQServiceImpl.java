package com.linjun.service.impl;

import com.linjun.dao.ApiUserQQMapper;
import com.linjun.entity.UserQQVo;
import com.linjun.service.ApiUserQQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiUserQQService")
public class ApiUserQQServiceImpl implements ApiUserQQService {
    @Autowired
    private ApiUserQQMapper apiUserQQMapper;
    @Override
    public UserQQVo queryObject(Long id) {
        return apiUserQQMapper.queryObject(id);
    }

    @Override
    public List<UserQQVo> queryList(Map<String, Object> map) {
        return apiUserQQMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserQQMapper.queryTotal(map);
    }

    @Override
    public void save(UserQQVo userQQVo) {
  apiUserQQMapper.save(userQQVo);
    }

    @Override
    public void update(UserQQVo userQQVo) {
apiUserQQMapper.update(userQQVo);
    }

    @Override
    public void delete(Long id) {
apiUserQQMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  apiUserQQMapper.deleteBatch(ids);
    }
}
