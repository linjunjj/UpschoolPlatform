package com.linjun.service.impl;

import com.linjun.dao.SkillCommentMapper;
import com.linjun.entity.SkillCommentEntity;
import com.linjun.service.SkillCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service("skillCommentService")
public class SkillCommentServiceImpl implements SkillCommentService {
    @Autowired
    private SkillCommentMapper skillCommentMapper;
    @Override
    public SkillCommentEntity queryObject(Long id) {
        return skillCommentMapper.queryObject(id);
    }

    @Override
    public List<SkillCommentEntity> queryList(Map<String, Object> map) {
        return skillCommentMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return skillCommentMapper.queryTotal(map);
    }

    @Override
    public void save(SkillCommentEntity skillCommentEntity) {
   skillCommentMapper.save(skillCommentEntity);
    }

    @Override
    public void update(SkillCommentEntity skillCommentEntity) {
  skillCommentMapper.update(skillCommentEntity);
    }

    @Override
    public void delete(Long id) {
   skillCommentMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   skillCommentMapper.deleteBatch(ids);
    }
}
