package com.linjun.service;

import com.linjun.entity.UserWeixinEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface ApiUserWeixinService {
    UserWeixinEntity queryObject(Long id);
    List<UserWeixinEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserWeixinEntity userWeixinEntity);
    void update(UserWeixinEntity userWeixinEntity);
    void delete(Long id);
     void deleteBatch(Long[] ids);

}
