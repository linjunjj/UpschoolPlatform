package com.linjun.service.impl;

import com.linjun.dao.ApiPartTimeCategoryMapper;
import com.linjun.entity.PartTimeCategoryEntity;
import com.linjun.service.ApiPartTimeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
public class ApiPartTimeCategoryServiceImpl implements ApiPartTimeCategoryService {
    @Autowired
    private ApiPartTimeCategoryMapper apiPartTimeCategoryMapper;
    @Override
    public PartTimeCategoryEntity queryObject(Integer id) {
        return apiPartTimeCategoryMapper.queryObject(id);
    }

    @Override
    public List<PartTimeCategoryEntity> queryList(Map<String, Object> map) {
        return apiPartTimeCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  apiPartTimeCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(PartTimeCategoryEntity partTimeCategoryEntity) {
    apiPartTimeCategoryMapper.save(partTimeCategoryEntity);
    }

    @Override
    public void update(PartTimeCategoryEntity partTimeCategoryEntity) {
apiPartTimeCategoryMapper.update(partTimeCategoryEntity);
    }

    @Override
    public void delete(Integer id) {
    apiPartTimeCategoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
      apiPartTimeCategoryMapper.deleteBatch(ids);
    }
}
