package com.linjun.service.impl;

import com.linjun.dao.ApiSkillEvaluateMapper;
import com.linjun.entity.SkillEvaluateEntity;
import com.linjun.service.ApiSkillEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service
public class ApiSkillEvaluateServiceImpl implements ApiSkillEvaluateService {
    @Autowired
    private ApiSkillEvaluateMapper apiSkillEvaluateMapper;
    @Override
    public SkillEvaluateEntity queryObject(Long id) {
        return apiSkillEvaluateMapper.queryObject(id);
    }

    @Override
    public List<SkillEvaluateEntity> queryList(Map<String, Object> map) {
        return apiSkillEvaluateMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSkillEvaluateMapper.queryTotal(map);
    }

    @Override
    public void save(SkillEvaluateEntity skillEvaluateEntity) {
apiSkillEvaluateMapper.save(skillEvaluateEntity);
    }

    @Override
    public void update(SkillEvaluateEntity skillEvaluateEntity) {
 apiSkillEvaluateMapper.update(skillEvaluateEntity);
    }

    @Override
    public void delete(Long id) {
   apiSkillEvaluateMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  apiSkillEvaluateMapper.deleteBatch(ids);
    }
}
