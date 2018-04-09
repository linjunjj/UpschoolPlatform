package com.linjun.service;

import com.linjun.entity.SearchHistoryEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/9.
 * @desc
 **/
public interface ApiSearchHistoryService {
    SearchHistoryEntity queryObject(Integer id);
    List<SearchHistoryEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SearchHistoryEntity reportEntity);
    void update(SearchHistoryEntity reportEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);
}
