package com.linjun.service.impl;

import com.linjun.dao.RentImageMapper;
import com.linjun.entity.RentImageEntity;
import com.linjun.service.RentImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
public class RentImageServcieImpl implements RentImageService {
    @Autowired
    private RentImageMapper rentImageMapper;
    @Override
    public RentImageEntity queryObject(Long id) {
        return rentImageMapper.queryObject(id);
    }

    @Override
    public List<RentImageEntity> queryList(Map<String, Object> map) {
        return rentImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return rentImageMapper.queryTotal(map);
    }

    @Override
    public void save(RentImageEntity rentImageEntity) {
    rentImageMapper.save(rentImageEntity);
    }

    @Override
    public void update(RentImageEntity rentImageEntity) {
   rentImageMapper.update(rentImageEntity);
    }

    @Override
    public void delete(Long id) {
   rentImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   rentImageMapper.deleteBatch(ids);
    }
}
