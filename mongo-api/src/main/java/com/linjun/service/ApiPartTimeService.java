package com.linjun.service;

import com.linjun.entity.PartTimeEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
public interface ApiPartTimeService {
    PartTimeEntity queryObject(Integer id);
    List<PartTimeEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(PartTimeEntity partTimeEntity);
    void update(PartTimeEntity partTimeEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);

}
