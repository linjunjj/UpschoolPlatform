package com.linjun.service.impl;

import com.linjun.dao.ApiIdleCategoryMapper;
import com.linjun.entity.IdleCategroyVo;
import com.linjun.service.ApiIdleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service("apiIdleCategoryService")
public class ApiIdleCategoryServiceImpl implements ApiIdleCategoryService {
    @Autowired
    private ApiIdleCategoryMapper apiIdleCategoryMapper;
    @Override
    public IdleCategroyVo queryObject(Long id) {
        return apiIdleCategoryMapper.queryObject(id);
    }

    @Override
    public List<IdleCategroyVo> queryList(Map<String, Object> map) {
        return apiIdleCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiIdleCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(IdleCategroyVo idleCategroyVo) {
          apiIdleCategoryMapper.save(idleCategroyVo);
    }

    @Override
    public void update(IdleCategroyVo idleCategroyVo) {
         apiIdleCategoryMapper.update(idleCategroyVo);
    }

    @Override
    public void delete(Long id) {
      apiIdleCategoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        apiIdleCategoryMapper.deleteBatch(ids);
    }
}
