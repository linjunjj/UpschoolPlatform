package com.linjun.service;

import com.linjun.entity.SignEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface SignService {
    SignEntity queryObject(Long id);
    List<SignEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(SignEntity signEntity);
    void update(SignEntity signEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
