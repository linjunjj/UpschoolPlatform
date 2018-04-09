package com.linjun.service;

import com.linjun.entity.SearchHistoryVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/9.
 * @desc
 **/
public interface ApiSearchHistoryService {
    SearchHistoryVo queryObject(Integer id);
    List<SearchHistoryVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SearchHistoryVo reportEntity);
    void update(SearchHistoryVo reportEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);
}
