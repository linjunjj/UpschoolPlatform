package com.linjun.service;

import com.linjun.entity.PartTimeApplyVolumEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
public interface ApiPartTimeApplyVolumService {
    PartTimeApplyVolumEntity queryObject(Long id);
    List<PartTimeApplyVolumEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(PartTimeApplyVolumEntity partTimeApplyVolumEntity);
    void update(PartTimeApplyVolumEntity partTimeApplyVolumEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
