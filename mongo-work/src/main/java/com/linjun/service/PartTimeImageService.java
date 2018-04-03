package com.linjun.service;

import com.linjun.entity.PartTimeImageEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service
public interface PartTimeImageService {
    PartTimeImageEntity queryObject(Long id);
    List<PartTimeImageEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(PartTimeImageEntity partTimeImageEntity);
    void update(PartTimeImageEntity partTimeImageEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
