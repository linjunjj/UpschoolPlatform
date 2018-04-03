package com.linjun.service.impl;

import com.linjun.dao.DynamicImageMapper;
import com.linjun.entity.DynamicImageEntity;
import com.linjun.service.DynamicImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
public class DynamicImageServiceImpl implements DynamicImageService {
    @Autowired
    private DynamicImageMapper dynamicImageMapper;
    @Override
    public DynamicImageEntity queryObject(Long id) {
        return dynamicImageMapper.queryObject(id);
    }

    @Override
    public List<DynamicImageEntity> queryList(Map<String, Object> map) {
        return dynamicImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return dynamicImageMapper.queryTotal(map);
    }

    @Override
    public void save(DynamicImageEntity dynamicImageEntity) {
   dynamicImageMapper.save(dynamicImageEntity);
    }

    @Override
    public void update(DynamicImageEntity dynamicImageEntity) {
   dynamicImageMapper.update(dynamicImageEntity);
    }

    @Override
    public void delete(Long id) {
   dynamicImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
dynamicImageMapper.deleteBatch(ids);
    }
}
