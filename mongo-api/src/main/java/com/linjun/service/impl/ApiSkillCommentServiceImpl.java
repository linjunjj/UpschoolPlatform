package com.linjun.service.impl;

import com.linjun.dao.ApiSkillCommentMapper;
import com.linjun.entity.SkillCommentVo;
import com.linjun.service.ApiSkillCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service("apiSkillCommentService")
public class ApiSkillCommentServiceImpl implements ApiSkillCommentService  {
    @Autowired
    private ApiSkillCommentMapper apiSkillCommentMapper;
    @Override
    public SkillCommentVo queryObject(Long id) {
        return apiSkillCommentMapper.queryObject(id);
    }

    @Override
    public List<SkillCommentVo> queryList(Map<String, Object> map) {
        return apiSkillCommentMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSkillCommentMapper.queryTotal(map);
    }

    @Override
    public void save(SkillCommentVo skillCommentVo) {
      apiSkillCommentMapper.save(skillCommentVo);
    }

    @Override
    public void update(SkillCommentVo skillCommentVo) {
    apiSkillCommentMapper.update(skillCommentVo);
    }

    @Override
    public void delete(Long id) {
   apiSkillCommentMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  apiSkillCommentMapper.deleteBatch(ids);
    }
}
