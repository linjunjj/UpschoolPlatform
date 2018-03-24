package com.linjun.service;

import com.apple.laf.AquaTreeUI;
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
public interface ApiPartTimeImageService {
    PartTimeImageEntity queryObject(Integer id);
    List<PartTimeImageEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(PartTimeImageEntity partTimeImageEntity);
    void update(PartTimeImageEntity partTimeImageEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);

}
