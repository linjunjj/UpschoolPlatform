package com.linjun.service.impl;

import com.linjun.dao.ApiDynamicImageMapper;
import com.linjun.entity.DynamicImageEntity;
import com.linjun.service.ApiDynamicImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service
public class ApiDynamicImageServiceImpl implements ApiDynamicImageService {
    @Autowired
    private ApiDynamicImageMapper apiDynamicImageMapper;

    @Override
    public DynamicImageEntity queryObject(Long id) {
        return apiDynamicImageMapper.queryObject(id);
    }

    @Override
    public List<DynamicImageEntity> queryList(Map<String, Object> map) {
        return apiDynamicImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiDynamicImageMapper.queryTotal(map);
    }

    @Override
    public void save(DynamicImageEntity dynamicImageEntity) {
        apiDynamicImageMapper.save(dynamicImageEntity);
    }

    @Override
    public void update(DynamicImageEntity dynamicImageEntity) {
      apiDynamicImageMapper.update(dynamicImageEntity);
    }

    @Override
    public void delete(Long id) {
       apiDynamicImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
      apiDynamicImageMapper.deleteBatch(ids);
    }
}
