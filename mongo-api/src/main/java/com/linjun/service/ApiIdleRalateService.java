package com.linjun.service;

import com.linjun.entity.IdleRalateVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/

public interface ApiIdleRalateService {
    IdleRalateVo queryObject(Long id);
    List<IdleRalateVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(IdleRalateVo idleRalateVo);
    void update(IdleRalateVo idleRalateVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
