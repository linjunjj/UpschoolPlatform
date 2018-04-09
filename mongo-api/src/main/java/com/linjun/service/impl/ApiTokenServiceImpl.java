package com.linjun.service.impl;

import com.linjun.dao.ApiTokenMapper;
import com.linjun.entity.TokenVo;
import com.linjun.service.ApiTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiTokenService")
public class ApiTokenServiceImpl implements ApiTokenService {
    @Autowired
    private ApiTokenMapper apiTokenMapper;
    @Override
    public TokenVo queryObject(Long id) {
        return apiTokenMapper.queryObject(id);
    }

    @Override
    public List<TokenVo> queryList(Map<String, Object> map) {
        return apiTokenMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiTokenMapper.queryTotal(map);
    }

    @Override
    public void save(TokenVo tokenVo) {
apiTokenMapper.save(tokenVo);
    }

    @Override
    public void update(TokenVo tokenVo) {
apiTokenMapper.update(tokenVo);
    }

    @Override
    public void delete(Long id) {
apiTokenMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiTokenMapper.deleteBatch(ids);
    }
}
