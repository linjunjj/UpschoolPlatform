package com.linjun.service;

import com.linjun.entity.SkillCategoryVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiSkillCategoryService {
    SkillCategoryVo queryObject(Long id);
    List<SkillCategoryVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SkillCategoryVo skillCategoryVo);
    void update(SkillCategoryVo skillCategoryVo);
    void delete(Long id);
        void deleteBatch(Long[] ids);

}
