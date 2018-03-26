package com.linjun.service.impl;

import com.linjun.dao.ApiSkillMapper;
import com.linjun.entity.SkillEntity;
import com.linjun.service.ApiSkillService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiSkillServiceImpl implements ApiSkillService {
    @Autowired
    private ApiSkillMapper apiSkillMapper;
    @Override
    public SkillEntity queryObject(Integer id) {
        return apiSkillMapper.queryObject(id);
    }

    @Override
    public List<SkillEntity> queryList(Map<String, Object> map) {
        return apiSkillMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSkillMapper.queryTotal(map);
    }

    @Override
    public void save(SkillEntity skillEntity) {
  apiSkillMapper.save(skillEntity);
    }

    @Override
    public void update(SkillEntity skillEntity) {
   apiSkillMapper.update(skillEntity);
    }

    @Override
    public void delete(Integer id) {
   apiSkillMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
    apiSkillMapper.deleteBatch(ids);
    }
}
