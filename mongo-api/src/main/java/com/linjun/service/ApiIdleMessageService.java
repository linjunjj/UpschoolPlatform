package com.linjun.service;

import com.linjun.entity.IdleMessageVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/

public interface ApiIdleMessageService {
    IdleMessageVo queryObject(Long id);
    List<IdleMessageVo>  queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void  save(IdleMessageVo idleMessageVo);
    void update(IdleMessageVo idleMessageVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
