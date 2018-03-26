package com.linjun.service;

import com.linjun.entity.SuggestEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface ApiSuggestService {
    SuggestEntity queryObject(Integer id);
    List<SuggestEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SuggestEntity suggestEntity);
    void update(SuggestEntity suggestEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);

}
