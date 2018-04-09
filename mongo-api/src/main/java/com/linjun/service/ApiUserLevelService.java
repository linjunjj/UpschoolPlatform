package com.linjun.service;

import com.linjun.entity.UserLevelVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiUserLevelService {
    UserLevelVo queryObject(Long id);
    List<UserLevelVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserLevelVo userLevelVo);
    void update(UserLevelVo userLevelVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
