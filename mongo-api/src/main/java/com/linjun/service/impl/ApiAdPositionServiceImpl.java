package com.linjun.service.impl;

import com.linjun.dao.ApiAdPositionMapper;
import com.linjun.entity.AdPositionEntity;
import com.linjun.service.ApiAdPositionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
public class ApiAdPositionServiceImpl implements ApiAdPositionService {
    @Autowired
    private ApiAdPositionMapper apiAdPositionMapper;

    @Override
    public AdPositionEntity queryObject(Integer id) {
        return apiAdPositionMapper.queryObject(id);
    }

    @Override
    public List<AdPositionEntity> queryList(Map<String, Object> map) {
        return apiAdPositionMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiAdPositionMapper.queryTotal(map);
    }

    @Override
    public void save(AdPositionEntity adPositionEntity) {
         apiAdPositionMapper.save(adPositionEntity);
    }

    @Override
    public void update(AdPositionEntity adPositionEntity) {
           apiAdPositionMapper.update(adPositionEntity);
    }

    @Override
    public void delete(Integer id) {
       apiAdPositionMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
         apiAdPositionMapper.deleteBatch(ids);
    }
}
