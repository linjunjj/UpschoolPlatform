package com.linjun.service.impl;

import com.linjun.dao.ApiIdleMapper;
import com.linjun.entity.IdleVo;
import com.linjun.service.ApiIdleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service("apiIdleService")
public class ApiIdleServiceImpl implements ApiIdleService {
    @Autowired
    private ApiIdleMapper apiIdleMapper;
    @Override
    public IdleVo queryObject(Long id) {
        return apiIdleMapper.queryObject(id);
    }

    @Override
    public List<IdleVo> queryList(Map<String, Object> map) {
        return apiIdleMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  apiIdleMapper.queryTotal(map);
    }

    @Override
    public void save(IdleVo idleVo) {
         apiIdleMapper.save(idleVo);
    }

    @Override
    public void update(IdleVo idleVo) {
         apiIdleMapper.update(idleVo);
    }

    @Override
    public void delete(Long id) {
       apiIdleMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
      apiIdleMapper.deleteBatch(ids);
    }
}
