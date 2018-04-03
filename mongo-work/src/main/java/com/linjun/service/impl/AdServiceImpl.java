package com.linjun.service.impl;

import com.linjun.dao.AdMapper;
import com.linjun.entity.AdEntity;
import com.linjun.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
public class AdServiceImpl implements AdService {
    @Autowired
    private AdMapper adMapper;
    @Override
    public AdEntity queryObject(Long id) {
        return adMapper.queryObject(id);
    }

    @Override
    public List<AdEntity> queryList(Map<String, Object> map) {
        return adMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return adMapper.queryTotal(map);
    }

    @Override
    public void save(AdEntity adEntity) {
   adMapper.save(adEntity);
    }

    @Override
    public void update(AdEntity adEntity) {
   adMapper.update(adEntity);
    }

    @Override
    public void delete(Long id) {
  adMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
    adMapper.deleteBatch(ids);
    }
}
