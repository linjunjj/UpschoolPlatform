package com.linjun.service.impl;

import com.linjun.dao.ApiPartTimeApplyVolumMapper;
import com.linjun.entity.PartTimeApplyVolumEntity;
import com.linjun.service.ApiPartTimeApplyVolumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
public class ApiPartTimeApplyVolumServiceImpl implements ApiPartTimeApplyVolumService {
    @Autowired
    private ApiPartTimeApplyVolumMapper apiPartTimeApplyVolumMapper;
    @Override
    public PartTimeApplyVolumEntity queryObject(Integer id) {
        return apiPartTimeApplyVolumMapper.queryObject(id);
    }

    @Override
    public List<PartTimeApplyVolumEntity> queryList(Map<String, Object> map) {
        return apiPartTimeApplyVolumMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiPartTimeApplyVolumMapper.queryTotal(map);
    }

    @Override
    public void save(PartTimeApplyVolumEntity partTimeApplyVolumEntity) {
       apiPartTimeApplyVolumMapper.save(partTimeApplyVolumEntity);
    }

    @Override
    public void update(PartTimeApplyVolumEntity partTimeApplyVolumEntity) {
      apiPartTimeApplyVolumMapper.update(partTimeApplyVolumEntity);
    }

    @Override
    public void delete(Integer id) {
     apiPartTimeApplyVolumMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
     apiPartTimeApplyVolumMapper.deleteBatch(ids);
    }
}
