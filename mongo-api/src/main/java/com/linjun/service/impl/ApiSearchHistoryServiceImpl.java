package com.linjun.service.impl;

import com.linjun.dao.ApiSearchHistoryMapper;
import com.linjun.entity.SearchHistoryEntity;
import com.linjun.service.ApiSearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/9.
 * @desc
 **/
@Service("apiSearchHistory")
public class ApiSearchHistoryServiceImpl implements ApiSearchHistoryService {
    @Autowired
    private ApiSearchHistoryMapper apiSearchHistoryMapper;
    @Override
    public SearchHistoryEntity queryObject(Integer id) {
        return apiSearchHistoryMapper.queryObject(id);
    }

    @Override
    public List<SearchHistoryEntity> queryList(Map<String, Object> map) {
        return apiSearchHistoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSearchHistoryMapper.queryTotal(map);
    }

    @Override
    public void save(SearchHistoryEntity reportEntity) {
     apiSearchHistoryMapper.save(reportEntity);
    }

    @Override
    public void update(SearchHistoryEntity reportEntity) {
  apiSearchHistoryMapper.update(reportEntity);
    }

    @Override
    public void delete(Integer id) {
 apiSearchHistoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
  apiSearchHistoryMapper.deleteBatch(ids);
    }
}
