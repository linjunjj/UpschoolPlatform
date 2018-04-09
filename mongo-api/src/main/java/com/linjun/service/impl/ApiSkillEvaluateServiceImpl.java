package com.linjun.service.impl;

import com.linjun.dao.ApiSkillEvaluateMapper;
import com.linjun.entity.SkillEvaluateVo;
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
@Service("apiSkillEvaluateService")
public class ApiSkillEvaluateServiceImpl implements ApiSkillEvaluateService {
    @Autowired
    private ApiSkillEvaluateMapper apiSkillEvaluateMapper;
    @Override
    public SkillEvaluateVo queryObject(Long id) {
        return apiSkillEvaluateMapper.queryObject(id);
    }

    @Override
    public List<SkillEvaluateVo> queryList(Map<String, Object> map) {
        return apiSkillEvaluateMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSkillEvaluateMapper.queryTotal(map);
    }

    @Override
    public void save(SkillEvaluateVo skillEvaluateVo) {
apiSkillEvaluateMapper.save(skillEvaluateVo);
    }

    @Override
    public void update(SkillEvaluateVo skillEvaluateVo) {
 apiSkillEvaluateMapper.update(skillEvaluateVo);
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
