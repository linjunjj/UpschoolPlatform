package com.linjun.service.impl;

import com.linjun.dao.ApiActivityMapper;
import com.linjun.entity.ActivityVo;
import com.linjun.service.ApiAcitvityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service("apiAcitvityService")
public class ApiAcitvityServiceImpl implements ApiAcitvityService{
    @Autowired
    private ApiActivityMapper apiActivityMapper;
    @Override
    public ActivityVo queryObject(Long id) {
        return apiActivityMapper.queryObject(id);
    }

    @Override
    public List<ActivityVo> queryList(Map<String, Object> map) {
        return apiActivityMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiActivityMapper.queryTotal(map);
    }

    @Override
    public void save(ActivityVo activityVo) {
         apiActivityMapper.save(activityVo);
    }

    @Override
    public void update(ActivityVo activityVo) {
      apiActivityMapper.update(activityVo);
    }

    @Override
    public void delete(Long id) {
     apiActivityMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   apiActivityMapper.deleteBatch(ids);
    }
}
