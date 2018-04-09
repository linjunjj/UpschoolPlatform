package com.linjun.service;

import com.linjun.entity.UserDynamicVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiUserDynamicService {
    UserDynamicVo queryObject(Long id);
    List<UserDynamicVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserDynamicVo userDynamicVo);
    void update(UserDynamicVo userDynamicVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
