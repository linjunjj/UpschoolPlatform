package com.linjun.service;

import com.linjun.entity.UserQQEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface UserQQService {
    UserQQEntity queryObject(Long id);
    List<UserQQEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(UserQQEntity userQQEntity);
    void update(UserQQEntity userQQEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
