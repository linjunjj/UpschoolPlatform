package com.linjun.service;

import com.linjun.entity.UserDynamicEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface UserDynamicService {
    UserDynamicEntity queryObject(Long id);
    List<UserDynamicEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(UserDynamicEntity userDynamicEntity);
    void update(UserDynamicEntity userDynamicEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
