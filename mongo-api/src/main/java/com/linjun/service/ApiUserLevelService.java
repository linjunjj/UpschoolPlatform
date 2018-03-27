package com.linjun.service;

import com.linjun.entity.UserLevelEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface ApiUserLevelService {
    UserLevelEntity queryObject(Long id);
    List<UserLevelEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserLevelEntity userLevelEntity);
    void update(UserLevelEntity userLevelEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
