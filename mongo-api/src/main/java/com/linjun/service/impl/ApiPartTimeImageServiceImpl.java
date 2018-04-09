package com.linjun.service.impl;

import com.linjun.dao.ApiPartTimeImageMapper;
import com.linjun.entity.PartTimeImageVo;
import com.linjun.service.ApiPartTimeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service("apiPartTimeImageService")
public class ApiPartTimeImageServiceImpl implements ApiPartTimeImageService {
    @Autowired
    private ApiPartTimeImageMapper apiPartTimeImageMapper;
    @Override
    public PartTimeImageVo queryObject(Long id) {
        return apiPartTimeImageMapper.queryObject(id);
    }

    @Override
    public List<PartTimeImageVo> queryList(Map<String, Object> map) {
        return apiPartTimeImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiPartTimeImageMapper.queryTotal(map);
    }

    @Override
    public void save(PartTimeImageVo partTimeImageVo) {
    apiPartTimeImageMapper.save(partTimeImageVo);
    }

    @Override
    public void update(PartTimeImageVo partTimeImageVo) {
    apiPartTimeImageMapper.update(partTimeImageVo);
    }

    @Override
    public void delete(Long id) {
  apiPartTimeImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  apiPartTimeImageMapper.deleteBatch(ids);
    }
}
