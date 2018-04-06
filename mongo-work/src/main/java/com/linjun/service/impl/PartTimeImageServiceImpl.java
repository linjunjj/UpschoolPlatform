package com.linjun.service.impl;

import com.linjun.dao.PartTimeImageMapper;
import com.linjun.entity.PartTimeImageEntity;
import com.linjun.service.PartTimeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service
public class PartTimeImageServiceImpl implements PartTimeImageService {
    @Autowired
    private PartTimeImageMapper partTimeImageMapper;
    @Override
    public PartTimeImageEntity queryObject(Long id) {
        return partTimeImageMapper.queryObject(id);
    }

    @Override
    public List<PartTimeImageEntity> queryList(Map<String, Object> map) {
        return partTimeImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return partTimeImageMapper.queryTotal(map);
    }

    @Override
    public void save(PartTimeImageEntity partTimeImageEntity) {
partTimeImageMapper.save(partTimeImageEntity);
    }

    @Override
    public void update(PartTimeImageEntity partTimeImageEntity) {
partTimeImageMapper.update(partTimeImageEntity);
    }

    @Override
    public void delete(Long id) {
partTimeImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
partTimeImageMapper.deleteBatch(ids);
    }
}
