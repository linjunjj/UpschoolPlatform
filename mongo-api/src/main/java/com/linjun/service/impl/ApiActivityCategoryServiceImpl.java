package com.linjun.service.impl;

import com.linjun.dao.ApiActivityCategoryMapper;
import com.linjun.entity.ActivityCategoryVo;
import com.linjun.service.ApiActivityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service("apiActivityCategoryService")
public class ApiActivityCategoryServiceImpl implements ApiActivityCategoryService {
    @Autowired
    private ApiActivityCategoryMapper apiActivityCategoryMapper;
    @Override
    public ActivityCategoryVo queryObject(Long id) {
        return apiActivityCategoryMapper.queryObject(id);
    }

    @Override
    public List<ActivityCategoryVo> queryList(Map<String, Object> map) {
        return apiActivityCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiActivityCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(ActivityCategoryVo activityCategoryVo) {
            apiActivityCategoryMapper.save(activityCategoryVo);
    }

    @Override
    public void update(ActivityCategoryVo activityCategoryVo) {
   apiActivityCategoryMapper.update(activityCategoryVo);
    }

    @Override
    public void delete(Long id) {
  apiActivityCategoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        apiActivityCategoryMapper.deleteBatch(ids);
    }
}
