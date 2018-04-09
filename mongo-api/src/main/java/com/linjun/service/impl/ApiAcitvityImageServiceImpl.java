package com.linjun.service.impl;

import com.linjun.dao.ApiActivityImageMapper;
import com.linjun.entity.ActivityImageVo;
import com.linjun.service.ApiAcitvityImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service("apiAcitvityImageService")
public class ApiAcitvityImageServiceImpl implements ApiAcitvityImageService {
@Autowired
private ApiActivityImageMapper apiActivityImageMapper;
    @Override
    public ActivityImageVo queryObject(Long id) {
        return apiActivityImageMapper.queryObject(id);
    }

    @Override
    public List<ActivityImageVo> queryList(Map<String, Object> map) {
        return apiActivityImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiActivityImageMapper.queryTotal(map);
    }

    @Override
    public void save(ActivityImageVo activityImageVo) {
        apiActivityImageMapper.save(activityImageVo);
    }

    @Override
    public void update(ActivityImageVo activityImageVo) {
          apiActivityImageMapper.update(activityImageVo);
    }

    @Override
    public void delete(Long id) {
            apiActivityImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
           apiActivityImageMapper.deleteBatch(ids);
    }
}
