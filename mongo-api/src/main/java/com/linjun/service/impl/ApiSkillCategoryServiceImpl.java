package com.linjun.service.impl;

import com.linjun.dao.ApiSkillCategoryMapper;
import com.linjun.entity.SkillCategoryVo;
import com.linjun.service.ApiSkillCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service("apiSkillCategoryService")
public class ApiSkillCategoryServiceImpl implements ApiSkillCategoryService {
    @Autowired
    private ApiSkillCategoryMapper apiSkillCategoryMapper;
    @Override
    public SkillCategoryVo queryObject(Long id) {
        return apiSkillCategoryMapper.queryObject(id);
    }

    @Override
    public List<SkillCategoryVo> queryList(Map<String, Object> map) {
        return apiSkillCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSkillCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(SkillCategoryVo skillCategoryVo) {
apiSkillCategoryMapper.save(skillCategoryVo);
    }

    @Override
    public void update(SkillCategoryVo skillCategoryVo) {
apiSkillCategoryMapper.update(skillCategoryVo);
    }

    @Override
    public void delete(Long id) {
apiSkillCategoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiSkillCategoryMapper.deleteBatch(ids);
    }
}
