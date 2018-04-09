package com.linjun.service.impl;

import com.linjun.dao.ApiRentImageMapper;
import com.linjun.entity.RentImageVo;
import com.linjun.service.ApiRentImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service("apiRentImageService")
public class ApiRentImageServiceImpl implements ApiRentImageService {
    @Autowired
    private ApiRentImageMapper apiRentImageMapper;

    @Override
    public RentImageVo queryObject(Long id) {
        return apiRentImageMapper.queryObject(id);
    }

    @Override
    public List<RentImageVo> queryList(Map<String, Object> map) {
        return apiRentImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiRentImageMapper.queryTotal(map);
    }

    @Override
    public void save(RentImageVo rentImageVo) {
       apiRentImageMapper.save(rentImageVo);
    }

    @Override
    public void update(RentImageVo rentImageVo) {
     apiRentImageMapper.update(rentImageVo);
    }

    @Override
    public void delete(Long id) {
     apiRentImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
    apiRentImageMapper.deleteBatch(ids);
    }
}
