package com.linjun.service.impl;

import com.linjun.dao.ApiRentCategoryMapper;
import com.linjun.entity.RentCategoryVo;
import com.linjun.service.ApiRentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service("apiRentCategoryService")
public class ApiRentCategoryServiceImpl implements ApiRentCategoryService {
    @Autowired
    private ApiRentCategoryMapper apiRentCategoryMapper;
    @Override
    public RentCategoryVo queryObject(Long id) {
        return apiRentCategoryMapper.queryObject(id);
    }

    @Override
    public List<RentCategoryVo> queryList(Map<String, Object> map) {
        return apiRentCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiRentCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(RentCategoryVo rentCategoryVo) {
    apiRentCategoryMapper.save(rentCategoryVo);
    }

    @Override
    public void update(RentCategoryVo rentCategoryVo) {
 apiRentCategoryMapper.update(rentCategoryVo);
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
