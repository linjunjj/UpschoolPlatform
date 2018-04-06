package com.linjun.service.impl;

import com.linjun.dao.PartTimeApplyVolumMapper;
import com.linjun.entity.PartTimeApplyVolumEntity;
import com.linjun.service.PartTimeApplyVolumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service("partTimeApplyVolumService")
public class PartTimeApplyVolumServiceImpl implements PartTimeApplyVolumService {
    @Autowired
    private PartTimeApplyVolumMapper partTimeApplyVolumMapper;
    @Override
    public PartTimeApplyVolumEntity queryObject(Long id) {
        return partTimeApplyVolumMapper.queryObject(id);
    }

    @Override
    public List<PartTimeApplyVolumEntity> queryList(Map<String, Object> map) {
        return partTimeApplyVolumMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  partTimeApplyVolumMapper.queryTotal(map);
    }

    @Override
    public void save(PartTimeApplyVolumEntity partTimeApplyVolumEntity) {
      partTimeApplyVolumMapper.save(partTimeApplyVolumEntity);
    }

    @Override
    public void update(PartTimeApplyVolumEntity partTimeApplyVolumEntity) {
    partTimeApplyVolumMapper.update(partTimeApplyVolumEntity);
    }

    @Override
    public void delete(Long id) {
   partTimeApplyVolumMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  partTimeApplyVolumMapper.deleteBatch(ids);
    }
}
