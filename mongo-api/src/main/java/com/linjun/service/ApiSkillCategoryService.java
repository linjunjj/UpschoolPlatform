package com.linjun.service;

import com.linjun.entity.SkillCategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service
public interface ApiSkillCategoryService {
    SkillCategoryEntity queryObject(Integer id);
    List<SkillCategoryEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SkillCategoryEntity skillCategoryEntity);
    void update(SkillCategoryEntity skillCategoryEntity);
    void delete(Integer id);
        void deleteBatch(Integer[] ids);

}
