package com.linjun.service.impl;

import com.linjun.dao.ApiIdleImagesMapper;
import com.linjun.entity.IdleImagesVo;
import com.linjun.service.ApiIdleImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service("apiIdleImageService")
public class ApiIdleImageServiceImpl implements ApiIdleImageService {
    @Autowired
    private ApiIdleImagesMapper apiIdleImagesMapper;
    @Override
    public IdleImagesVo queryObject(Long id) {
        return apiIdleImagesMapper.queryObject(id);
    }

    @Override
    public List<IdleImagesVo> queryList(Map<String, Object> map) {
        return apiIdleImagesMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiIdleImagesMapper.queryTotal(map);
    }

    @Override
    public void save(IdleImagesVo idleImagesVo) {
         apiIdleImagesMapper.save(idleImagesVo);
    }

    @Override
    public void update(IdleImagesVo idleImagesVo) {
       apiIdleImagesMapper.update(idleImagesVo);
    }

    @Override
    public void delete(Long id) {
 apiIdleImagesMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
       apiIdleImagesMapper.deleteBatch(ids);
    }
}
