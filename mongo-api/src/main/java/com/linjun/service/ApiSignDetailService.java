package com.linjun.service;

import com.linjun.entity.SignDetailEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiSignDetailService {
    SignDetailEntity queryObject(Long id);
    List<SignDetailEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SignDetailEntity signDetailEntity);
    void update(SignDetailEntity signDetailEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
