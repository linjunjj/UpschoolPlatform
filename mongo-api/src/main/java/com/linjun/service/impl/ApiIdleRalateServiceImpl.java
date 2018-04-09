package com.linjun.service.impl;

import com.linjun.dao.ApiIdleRalateMapper;
import com.linjun.entity.IdleRalateVo;
import com.linjun.service.ApiIdleRalateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service("apiIdleRalateService")
public class ApiIdleRalateServiceImpl implements ApiIdleRalateService{
    @Autowired
    private ApiIdleRalateMapper apiIdleRalateMapper;
    @Override
    public IdleRalateVo queryObject(Long id) {
        return apiIdleRalateMapper.queryObject(id);
    }

    @Override
    public List<IdleRalateVo> queryList(Map<String, Object> map) {
        return apiIdleRalateMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiIdleRalateMapper.queryTotal(map);
    }

    @Override
    public void save(IdleRalateVo idleRalateVo) {
       apiIdleRalateMapper.save(idleRalateVo);
    }

    @Override
    public void update(IdleRalateVo idleRalateVo) {
        apiIdleRalateMapper.update(idleRalateVo);
    }

    @Override
    public void delete(Long id) {
       apiIdleRalateMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
      apiIdleRalateMapper.deleteBatch(ids);
    }
}
