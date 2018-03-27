package com.linjun.service;

import com.linjun.entity.AdEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service
public interface ApiAdService {
    AdEntity queryObject(Long id);
    List<AdEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(AdEntity adEntity);
     void update(AdEntity adEntity);
     void delete(Long id);
    void deleteBatch(Long[] ids);

}
