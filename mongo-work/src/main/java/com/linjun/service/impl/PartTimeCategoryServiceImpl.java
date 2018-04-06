package com.linjun.service.impl;

import com.linjun.dao.PartTimeCategoryMapper;
import com.linjun.entity.PartTimeCategoryEntity;
import com.linjun.service.PartTimeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service("partTimeCategoryService")
public class PartTimeCategoryServiceImpl implements PartTimeCategoryService {
    @Autowired
    private PartTimeCategoryMapper partTimeCategoryMapper;
    @Override
    public PartTimeCategoryEntity queryObject(Long id) {
        return partTimeCategoryMapper.queryObject(id);
    }

    @Override
    public List<PartTimeCategoryEntity> queryList(Map<String, Object> map) {
        return partTimeCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  partTimeCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(PartTimeCategoryEntity partTimeCategoryEntity) {
      partTimeCategoryMapper.save(partTimeCategoryEntity);
    }

    @Override
    public void update(PartTimeCategoryEntity partTimeCategoryEntity) {
   partTimeCategoryMapper.update(partTimeCategoryEntity);
    }

    @Override
    public void delete(Long id) {
  partTimeCategoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  partTimeCategoryMapper.deleteBatch(ids);
    }
}
