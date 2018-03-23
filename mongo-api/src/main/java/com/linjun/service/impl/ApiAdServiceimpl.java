package com.linjun.service.impl;

import com.linjun.dao.ApiAdMapper;
import com.linjun.entity.AdEntity;
import com.linjun.service.ApiAdService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
public class ApiAdServiceimpl implements ApiAdService {
    @Autowired
    private ApiAdMapper apiAdMapper;
    @Override
    public AdEntity queryObject(Integer id) {
        return apiAdMapper.queryObject(id);
    }

    @Override
    public List<AdEntity> queryList(Map<String, Object> map) {
        return apiAdMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiAdMapper.queryTotal(map);
    }

    @Override
    public void save(AdEntity adEntity) {
        apiAdMapper.save(adEntity);
    }

    @Override
    public void update(AdEntity adEntity) {
      apiAdMapper.update(adEntity);
    }

    @Override
    public void delete(Integer id) {
     apiAdMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
   apiAdMapper.deleteBatch(ids);
    }
}
