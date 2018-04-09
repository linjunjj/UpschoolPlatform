package com.linjun.service;

import com.linjun.entity.UserWeixinVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiUserWeixinService {
    UserWeixinVo queryObject(Long id);
    List<UserWeixinVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserWeixinVo userWeixinVo);
    void update(UserWeixinVo userWeixinVo);
    void delete(Long id);
     void deleteBatch(Long[] ids);

}
