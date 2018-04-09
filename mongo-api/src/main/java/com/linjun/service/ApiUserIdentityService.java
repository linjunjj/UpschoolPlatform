package com.linjun.service;

import com.linjun.entity.UserIdentityVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiUserIdentityService {
    UserIdentityVo queryObject(Long id);
    List<UserIdentityVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserIdentityVo userIdentityVo);
    void update(UserIdentityVo userIdentityVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
