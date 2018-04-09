package com.linjun.service;

import com.linjun.entity.UserQQVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiUserQQService {
    UserQQVo queryObject(Long id);
    List<UserQQVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserQQVo userQQVo);
    void update(UserQQVo userQQVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
