package com.linjun.service.impl;

import com.linjun.dao.ApiSkillMapper;
import com.linjun.entity.SkillVo;
import com.linjun.service.ApiSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiSkillService")
public class ApiSkillServiceImpl implements ApiSkillService {
    @Autowired
    private ApiSkillMapper apiSkillMapper;
    @Override
    public SkillVo queryObject(Long id) {
        return apiSkillMapper.queryObject(id);
    }

    @Override
    public List<SkillVo> queryList(Map<String, Object> map) {
        return apiSkillMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSkillMapper.queryTotal(map);
    }

    @Override
    public void save(SkillVo skillVo) {
  apiSkillMapper.save(skillVo);
    }

    @Override
    public void update(SkillVo skillVo) {
   apiSkillMapper.update(skillVo);
    }

    @Override
    public void delete(Long id) {
   apiSkillMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
    apiSkillMapper.deleteBatch(ids);
    }
}
