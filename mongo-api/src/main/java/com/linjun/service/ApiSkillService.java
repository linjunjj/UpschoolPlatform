package com.linjun.service;

import com.linjun.entity.SkillVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiSkillService {
    SkillVo queryObject(Long id);
    List<SkillVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SkillVo skillVo);
    void update(SkillVo skillVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
