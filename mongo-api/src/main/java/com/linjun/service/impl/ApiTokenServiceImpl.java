package com.linjun.service.impl;

import com.linjun.dao.ApiTokenMapper;
import com.linjun.entity.TokenEntity;
import com.linjun.service.ApiTokenService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiTokenServiceImpl implements ApiTokenService {
    @Autowired
    private ApiTokenMapper apiTokenMapper;
    @Override
    public TokenEntity queryObject(Integer id) {
        return apiTokenMapper.queryObject(id);
    }

    @Override
    public List<TokenEntity> queryList(Map<String, Object> map) {
        return apiTokenMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiTokenMapper.queryTotal(map);
    }

    @Override
    public void save(TokenEntity tokenEntity) {
apiTokenMapper.save(tokenEntity);
    }

    @Override
    public void update(TokenEntity tokenEntity) {
apiTokenMapper.update(tokenEntity);
    }

    @Override
    public void delete(Integer id) {
apiTokenMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
apiTokenMapper.deleteBatch(ids);
    }
}
