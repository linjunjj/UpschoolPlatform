package com.linjun.service.impl;

import com.linjun.dao.ApiSkillImageMapper;
import com.linjun.entity.SkillImageVo;
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
@Service("apiSkillImageService")
public class ApiSkillImageServiceImpl implements ApiSkillImageService {
    @Autowired
    private ApiSkillImageMapper apiSkillImageMapper;
    @Override
    public SkillImageVo queryObject(Long id) {
        return apiSkillImageMapper.queryObject(id);
    }

    @Override
    public List<SkillImageVo> queryList(Map<String, Object> map) {
        return apiSkillImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSkillImageMapper.queryTotal(map);
    }

    @Override
    public void save(SkillImageVo skillImageVo) {
   apiSkillImageMapper.save(skillImageVo);
    }

    @Override
    public void update(SkillImageVo skillImageVo) {
  apiSkillImageMapper.update(skillImageVo);
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
