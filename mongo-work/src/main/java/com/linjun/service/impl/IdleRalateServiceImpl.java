package com.linjun.service.impl;

import com.linjun.dao.IdleRalateMapper;
import com.linjun.entity.IdleRalateEntity;
import com.linjun.service.IdleRalateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service("idleRalateService")
public class IdleRalateServiceImpl implements IdleRalateService {
    @Autowired
    private IdleRalateMapper idleRalateMapper;
    @Override
    public IdleRalateEntity queryObject(Long id) {
        return idleRalateMapper.queryObject(id);
    }

    @Override
    public List<IdleRalateEntity> queryList(Map<String, Object> map) {
        return idleRalateMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return idleRalateMapper.queryTotal(map);
    }

    @Override
    public void save(IdleRalateEntity idleRalateEntity) {
  idleRalateMapper.save(idleRalateEntity);
    }

    @Override
    public void update(IdleRalateEntity idleRalateEntity) {
  idleRalateMapper.update(idleRalateEntity);
    }

    @Override
    public void delete(Long id) {
 idleRalateMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  idleRalateMapper.deleteBatch(ids);
    }
}
