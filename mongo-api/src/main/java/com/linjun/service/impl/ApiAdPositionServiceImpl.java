package com.linjun.service.impl;

import com.linjun.dao.ApiAdPositionMapper;
import com.linjun.entity.AdPositionVo;
import com.linjun.service.ApiAdPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service("apiAdPositionService")
public class ApiAdPositionServiceImpl implements ApiAdPositionService {
    @Autowired
    private ApiAdPositionMapper apiAdPositionMapper;

    @Override
    public AdPositionVo queryObject(Long id) {
        return apiAdPositionMapper.queryObject(id);
    }

    @Override
    public List<AdPositionVo> queryList(Map<String, Object> map) {
        return apiAdPositionMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiAdPositionMapper.queryTotal(map);
    }

    @Override
    public void save(AdPositionVo adPositionVo) {
         apiAdPositionMapper.save(adPositionVo);
    }

    @Override
    public void update(AdPositionVo adPositionVo) {
           apiAdPositionMapper.update(adPositionVo);
    }

    @Override
    public void delete(Long id) {
       apiAdPositionMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
         apiAdPositionMapper.deleteBatch(ids);
    }
}
