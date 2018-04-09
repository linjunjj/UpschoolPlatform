package com.linjun.service.impl;

import com.linjun.dao.ApiAdMapper;
import com.linjun.entity.AdVo;
import com.linjun.service.ApiAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service("apiAdService")
public class ApiAdServiceimpl implements ApiAdService {
    @Autowired
    private ApiAdMapper apiAdMapper;
    @Override
    public AdVo queryObject(Long id) {
        return apiAdMapper.queryObject(id);
    }

    @Override
    public List<AdVo> queryList(Map<String, Object> map) {
        return apiAdMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiAdMapper.queryTotal(map);
    }

    @Override
    public void save(AdVo adVo) {
        apiAdMapper.save(adVo);
    }

    @Override
    public void update(AdVo adVo) {
      apiAdMapper.update(adVo);
    }

    @Override
    public void delete(Long id) {
     apiAdMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   apiAdMapper.deleteBatch(ids);
    }
}
