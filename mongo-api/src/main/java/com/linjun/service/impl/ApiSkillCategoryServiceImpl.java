package com.linjun.service.impl;

import com.linjun.dao.ApiSkillCategoryMapper;
import com.linjun.entity.SkillCategoryEntity;
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
    public SkillCategoryEntity queryObject(Long id) {
        return apiSkillCategoryMapper.queryObject(id);
    }

    @Override
    public List<SkillCategoryEntity> queryList(Map<String, Object> map) {
        return apiSkillCategoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSkillCategoryMapper.queryTotal(map);
    }

    @Override
    public void save(SkillCategoryEntity skillCategoryEntity) {
apiSkillCategoryMapper.save(skillCategoryEntity);
    }

    @Override
    public void update(SkillCategoryEntity skillCategoryEntity) {
apiSkillCategoryMapper.update(skillCategoryEntity);
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
