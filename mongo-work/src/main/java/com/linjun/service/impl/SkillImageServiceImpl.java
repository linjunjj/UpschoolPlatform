package com.linjun.service.impl;

import com.linjun.dao.SkillImageMapper;
import com.linjun.entity.SkillImageEntity;
import com.linjun.service.SkillImageService;
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
public class SkillImageServiceImpl implements SkillImageService {
    @Autowired
    private SkillImageMapper skillImageMapper;
    @Override
    public SkillImageEntity queryObject(Long id) {
        return skillImageMapper.queryObject(id);
    }

    @Override
    public List<SkillImageEntity> queryList(Map<String, Object> map) {
        return skillImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return skillImageMapper.queryTotal(map);
    }

    @Override
    public void save(SkillImageEntity skillImageEntity) {
       skillImageMapper.save(skillImageEntity);
    }

    @Override
    public void update(SkillImageEntity skillImageEntity) {
   skillImageMapper.update(skillImageEntity);
    }

    @Override
    public void delete(Long id) {
   skillImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   skillImageMapper.deleteBatch(ids);
    }
}
