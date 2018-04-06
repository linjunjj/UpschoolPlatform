package com.linjun.service.impl;

import com.linjun.dao.SkillEvaluateMapper;
import com.linjun.entity.SkillEvaluateEntity;
import com.linjun.service.SkillEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
@Service("skillEvaluateService")
public class SkillEvaluateServiceImpl implements SkillEvaluateService {
    @Autowired
    private SkillEvaluateMapper skillEvaluateMapper;
    @Override
    public SkillEvaluateEntity queryObject(Long id) {
        return skillEvaluateMapper.queryObject(id);
    }

    @Override
    public List<SkillEvaluateEntity> queryList(Map<String, Object> map) {
        return skillEvaluateMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return skillEvaluateMapper.queryTotal(map);
    }

    @Override
    public void save(SkillEvaluateEntity skillEvaluateEntity) {
   skillEvaluateMapper.save(skillEvaluateEntity);
    }

    @Override
    public void update(SkillEvaluateEntity skillEvaluateEntity) {
    skillEvaluateMapper.update(skillEvaluateEntity);
    }

    @Override
    public void delete(Long id) {
   skillEvaluateMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {

    }
}
