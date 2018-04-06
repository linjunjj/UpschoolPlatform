package com.linjun.service.impl;

import com.linjun.dao.AdPositionMapper;
import com.linjun.entity.AdPositionEntity;
import com.linjun.service.AdPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service("adPositionService")
public class AdPositionServiceImpl implements AdPositionService {
    @Autowired
    private AdPositionMapper adPositionMapper;
    @Override
    public AdPositionEntity queryObject(Long id) {
        return adPositionMapper.queryObject(id);
    }

    @Override
    public List<AdPositionEntity> queryList(Map<String, Object> map) {
        return adPositionMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return adPositionMapper.queryTotal(map);
    }

    @Override
    public void save(AdPositionEntity adPositionEntity) {
   adPositionMapper.save(adPositionEntity);
    }

    @Override
    public void update(AdPositionEntity adPositionEntity) {
  adPositionMapper.update(adPositionEntity);
    }

    @Override
    public void delete(Long id) {
  adPositionMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  adPositionMapper.deleteBatch(ids);
    }
}
