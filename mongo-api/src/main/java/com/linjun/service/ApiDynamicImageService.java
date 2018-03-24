package com.linjun.service;

import com.linjun.entity.DynamicImageEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service
public interface ApiDynamicImageService {
    DynamicImageEntity queryObject(Integer id);
    List<DynamicImageEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(DynamicImageEntity dynamicImageEntity);
    void update(DynamicImageEntity dynamicImageEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);
}
