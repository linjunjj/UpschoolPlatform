package com.linjun.service;

import com.linjun.entity.UserAttenVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiUserAttenService {
    UserAttenVo queryObject(Long id);
    List<UserAttenVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserAttenVo userAttenVo);
    void update(UserAttenVo userAttenVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
