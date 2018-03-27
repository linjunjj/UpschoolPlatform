package com.linjun.service.impl;

import com.linjun.dao.ApiRentCategoryMapper;
import com.linjun.entity.RentCategoryEntity;
import com.linjun.service.ApiRentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
public class ApiRentCategoryServiceImpl implements ApiRentCategoryService {
    @Autowired
    private ApiRentCategoryMapper apiRentCategoryMapper;
    @Override
    public RentCategoryEntity queryObject(Long id) {
        return apiRentCategoryMapper.queryObject(id);
    }

    @Override
    public List<RentCategoryEntity> queryList(Map<String, Object> map) {
        return apiRentCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiRentCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(RentCategoryEntity rentCategoryEntity) {
    apiRentCategoryMapper.save(rentCategoryEntity);
    }

    @Override
    public void update(RentCategoryEntity rentCategoryEntity) {
 apiRentCategoryMapper.update(rentCategoryEntity);
    }

    @Override
    public void delete(Long id) {
       apiRentCategoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
         apiRentCategoryMapper.deleteBatch(ids);
    }
}
