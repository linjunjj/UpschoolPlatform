package com.linjun.service;

import com.linjun.entity.SkillEvaluateVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiSkillEvaluateService {
    SkillEvaluateVo queryObject(Long id);
    List<SkillEvaluateVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SkillEvaluateVo skillEvaluateVo);
    void update(SkillEvaluateVo skillEvaluateVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
