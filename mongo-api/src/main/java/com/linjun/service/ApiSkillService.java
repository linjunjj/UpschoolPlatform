package com.linjun.service;

import com.linjun.entity.SkillEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiSkillService {
    SkillEntity queryObject(Long id);
    List<SkillEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SkillEntity skillEntity);
    void update(SkillEntity skillEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
