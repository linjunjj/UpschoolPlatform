package com.linjun.service.impl;

import com.linjun.dao.IdleCategoryMapper;
import com.linjun.entity.IdleCategroyEntity;
import com.linjun.service.IdleCategoryService;
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
public class IdleCategoryServiveImpl implements IdleCategoryService {
    @Autowired
    private IdleCategoryMapper idleCategoryMapper;
    @Override
    public IdleCategroyEntity queryObject(Long id) {
        return idleCategoryMapper.queryObject(id);
    }

    @Override
    public List<IdleCategroyEntity> queryList(Map<String, Object> map) {
        return idleCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return idleCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(IdleCategroyEntity idleCategroyEntity) {
  idleCategoryMapper.save(idleCategroyEntity);
    }

    @Override
    public void update(IdleCategroyEntity idleCategroyEntity) {
  idleCategoryMapper.update(idleCategroyEntity);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteBatch(Long[] ids) {

    }
}
