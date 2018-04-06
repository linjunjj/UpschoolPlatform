package com.linjun.service.impl;

import com.linjun.dao.IdleMapper;
import com.linjun.entity.IdleEntity;
import com.linjun.service.IdleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service("idleService")
public class IdleServiceImpl implements IdleService {
    @Autowired
    private IdleMapper idleMapper;
    @Override
    public IdleEntity queryObject(Long id) {
        return idleMapper.queryObject(id);
    }

    @Override
    public List<IdleEntity> queryList(Map<String, Object> map) {
        return idleMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return idleMapper.queryTotal(map);
    }

    @Override
    public void save(IdleEntity idleEntity) {
     idleMapper.save(idleEntity);
    }

    @Override
    public void update(IdleEntity idleEntity) {
   idleMapper.update(idleEntity);
    }

    @Override
    public void delete(Long id) {
 idleMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  idleMapper.deleteBatch(ids);
    }
}
