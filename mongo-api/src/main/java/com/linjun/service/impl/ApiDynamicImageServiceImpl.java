package com.linjun.service.impl;

import com.linjun.dao.ApiDynamicImageMapper;
import com.linjun.entity.DynamicImageVo;
import com.linjun.service.ApiDynamicImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service("apiDynamicImageService")
public class ApiDynamicImageServiceImpl implements ApiDynamicImageService {
    @Autowired
    private ApiDynamicImageMapper apiDynamicImageMapper;

    @Override
    public DynamicImageVo queryObject(Long id) {
        return apiDynamicImageMapper.queryObject(id);
    }

    @Override
    public List<DynamicImageVo> queryList(Map<String, Object> map) {
        return apiDynamicImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiDynamicImageMapper.queryTotal(map);
    }

    @Override
    public void save(DynamicImageVo dynamicImageVo) {
        apiDynamicImageMapper.save(dynamicImageVo);
    }

    @Override
    public void update(DynamicImageVo dynamicImageVo) {
      apiDynamicImageMapper.update(dynamicImageVo);
    }

    @Override
    public void delete(Long id) {
       apiDynamicImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
      apiDynamicImageMapper.deleteBatch(ids);
    }
}
