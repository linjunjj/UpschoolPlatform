package com.linjun.service;

import com.linjun.entity.SkillImageEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface SkillImageService {
    SkillImageEntity queryObject(Long id);
    List<SkillImageEntity>  queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(SkillImageEntity skillImageEntity);
    void update(SkillImageEntity skillImageEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
