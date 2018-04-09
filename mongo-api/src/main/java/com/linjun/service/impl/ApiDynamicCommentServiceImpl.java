package com.linjun.service.impl;

import com.linjun.dao.ApiDynamicCommentMapper;
import com.linjun.entity.DynamicCommentVo;
import com.linjun.service.ApiDynamicCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service("apiDynamicCommentService")
public class ApiDynamicCommentServiceImpl implements ApiDynamicCommentService{
    @Autowired
    private ApiDynamicCommentMapper apiDynamicCommentMapper;

    @Override
    public DynamicCommentVo queryObject(Long id) {
        return apiDynamicCommentMapper.queryObject(id);
    }

    @Override
    public List<DynamicCommentVo> queryList(Map<String, Object> map) {
        return apiDynamicCommentMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiDynamicCommentMapper.queryTotal(map);
    }

    @Override
    public void save(DynamicCommentVo dynamicCommentVo) {
       apiDynamicCommentMapper.save(dynamicCommentVo);
    }

    @Override
    public void update(DynamicCommentVo dynamicCommentVo) {
      apiDynamicCommentMapper.update(dynamicCommentVo);
    }

    @Override
    public void delete(Long id) {
     apiDynamicCommentMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
           apiDynamicCommentMapper.deleteBatch(ids);
    }
}
