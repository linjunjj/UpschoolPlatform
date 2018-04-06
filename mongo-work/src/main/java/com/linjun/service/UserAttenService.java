package com.linjun.service;

import com.linjun.entity.UserAttenEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface UserAttenService {
    UserAttenEntity queryObject(Long id);
    List<UserAttenEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(UserAttenEntity userAttenEntity);
    void update(UserAttenEntity userAttenEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
