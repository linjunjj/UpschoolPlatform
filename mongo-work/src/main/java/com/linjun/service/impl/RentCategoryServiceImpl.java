package com.linjun.service.impl;

import com.linjun.dao.RentCategoryMapper;
import com.linjun.entity.RentCategoryEntity;
import com.linjun.service.RentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service("rentCategoryService")
public class RentCategoryServiceImpl implements RentCategoryService {
    @Autowired
    private RentCategoryMapper rentCategoryMapper;
    @Override
    public RentCategoryEntity queryObject(Long id) {
        return rentCategoryMapper.queryObject(id);
    }

    @Override
    public List<RentCategoryEntity> queryList(Map<String, Object> map) {
        return rentCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return rentCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(RentCategoryEntity rentCategoryEntity) {
   rentCategoryMapper.save(rentCategoryEntity);
    }

    @Override
    public void update(RentCategoryEntity rentCategoryEntity) {
rentCategoryMapper.update(rentCategoryEntity);
    }

    @Override
    public void delete(Long id) {
   rentCategoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   rentCategoryMapper.deleteBatch(ids);
    }
}
