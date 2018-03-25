package com.linjun.service.impl;

import com.linjun.dao.ApiSkillCommentMapper;
import com.linjun.entity.SkillCommentEntity;
import com.linjun.service.ApiSkillCommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
public class ApiSkillCommentServiceImpl implements ApiSkillCommentService  {
    @Autowired
    private ApiSkillCommentMapper apiSkillCommentMapper;
    @Override
    public SkillCommentEntity queryObject(Integer id) {
        return apiSkillCommentMapper.queryObject(id);
    }

    @Override
    public List<SkillCommentEntity> queryList(Map<String, Object> map) {
        return apiSkillCommentMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSkillCommentMapper.queryTotal(map);
    }

    @Override
    public void save(SkillCommentEntity skillCommentEntity) {
      apiSkillCommentMapper.save(skillCommentEntity);
    }

    @Override
    public void update(SkillCommentEntity skillCommentEntity) {
    apiSkillCommentMapper.update(skillCommentEntity);
    }

    @Override
    public void delete(Integer id) {
   apiSkillCommentMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
  apiSkillCommentMapper.deleteBatch(ids);
    }
}
