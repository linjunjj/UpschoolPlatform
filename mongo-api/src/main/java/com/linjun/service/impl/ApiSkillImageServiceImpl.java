package com.linjun.service.impl;

import com.linjun.dao.ApiSkillImageMapper;
import com.linjun.entity.SkillImageEntity;
import com.linjun.service.ApiSkillImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public class ApiSkillImageServiceImpl implements ApiSkillImageService {
    @Autowired
    private ApiSkillImageMapper apiSkillImageMapper;
    @Override
    public SkillImageEntity queryObject(Long id) {
        return apiSkillImageMapper.queryObject(id);
    }

    @Override
    public List<SkillImageEntity> queryList(Map<String, Object> map) {
        return apiSkillImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSkillImageMapper.queryTotal(map);
    }

    @Override
    public void save(SkillImageEntity skillImageEntity) {
   apiSkillImageMapper.save(skillImageEntity);
    }

    @Override
    public void update(SkillImageEntity skillImageEntity) {
  apiSkillImageMapper.update(skillImageEntity);
    }

    @Override
    public void delete(Long id) {
apiSkillImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiSkillImageMapper.deleteBatch(ids);
    }
}
