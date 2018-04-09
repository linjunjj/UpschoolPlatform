package com.linjun.service;

import com.linjun.entity.SkillImageVo;

import java.util.List;
import java.util.Map;


/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiSkillImageService {
    SkillImageVo queryObject(Long id);
    List<SkillImageVo>  queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SkillImageVo skillImageVo);
    void update(SkillImageVo skillImageVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
