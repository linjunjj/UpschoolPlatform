package com.linjun.service.impl;

import com.linjun.dao.SkillCategoryMapper;
import com.linjun.entity.SkillCategoryEntity;
import com.linjun.service.SkillCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {
    @Autowired
    private SkillCategoryMapper skillCategoryMapper;
    @Override
    public SkillCategoryEntity queryObject(Long id) {
        return skillCategoryMapper.queryObject(id);
    }

    @Override
    public List<SkillCategoryEntity> queryList(Map<String, Object> map) {
        return skillCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return skillCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(SkillCategoryEntity skillCategoryEntity) {
   skillCategoryMapper.save(skillCategoryEntity);
    }

    @Override
    public void update(SkillCategoryEntity skillCategoryEntity) {
  skillCategoryMapper.update(skillCategoryEntity);
    }

    @Override
    public void delete(Long id) {
   skillCategoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  skillCategoryMapper.deleteBatch(ids);
    }
}
