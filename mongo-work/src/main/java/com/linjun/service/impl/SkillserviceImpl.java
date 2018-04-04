package com.linjun.service.impl;

import com.linjun.dao.SkillMapper;
import com.linjun.entity.SkillEntity;
import com.linjun.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
public class SkillserviceImpl implements SkillService {
    @Autowired
    private SkillMapper skillMapper;
    @Override
    public SkillEntity queryObject(Long id) {
        return skillMapper.queryObject(id);
    }

    @Override
    public List<SkillEntity> queryList(Map<String, Object> map) {
        return skillMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return skillMapper.queryTotal(map);
    }

    @Override
    public void save(SkillEntity skillEntity) {
   skillMapper.save(skillEntity);
    }

    @Override
    public void update(SkillEntity skillEntity) {
   skillMapper.update(skillEntity);
    }

    @Override
    public void delete(Long id) {
   skillMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   skillMapper.deleteBatch(ids);
    }
}
