package com.linjun.service;

import com.linjun.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface ApiUserService {
    UserEntity queryObject(Long id);
    List<UserEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserEntity userEntity);
    void update(UserEntity userEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
