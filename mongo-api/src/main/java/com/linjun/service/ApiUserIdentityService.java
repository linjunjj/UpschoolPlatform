package com.linjun.service;

import com.linjun.entity.UserIdentityEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface ApiUserIdentityService {
    UserIdentityEntity queryObject(Long id);
    List<UserIdentityEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserIdentityEntity userIdentityEntity);
    void update(UserIdentityEntity userIdentityEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
