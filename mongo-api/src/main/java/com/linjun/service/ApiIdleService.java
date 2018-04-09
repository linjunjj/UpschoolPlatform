package com.linjun.service;

import com.linjun.entity.IdleVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/

public interface ApiIdleService  {
    IdleVo queryObject(Long id);
    List<IdleVo>  queryList(Map<String,Object>map);
    int queryTotal(Map<String,Object> map);
   void save(IdleVo idleVo);
   void update(IdleVo idleVo);
   void delete(Long id);
    void deleteBatch(Long[] ids);
}
