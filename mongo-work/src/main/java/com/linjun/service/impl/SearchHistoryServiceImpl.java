package com.linjun.service.impl;

import com.linjun.dao.SearchHistoryMapper;
import com.linjun.entity.SearchHistoryEntity;
import com.linjun.service.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/9.
 * @desc
 **/
@Service("searchHistory")
public class SearchHistoryServiceImpl implements SearchHistoryService {
    @Autowired
    private SearchHistoryMapper searchHistoryMapper;
    @Override
    public SearchHistoryEntity queryObject(Integer id) {
        return searchHistoryMapper.queryObject(id);
    }

    @Override
    public List<SearchHistoryEntity> queryList(Map<String, Object> map) {
        return searchHistoryMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return searchHistoryMapper.queryTotal(map);
    }

    @Override
    public void save(SearchHistoryEntity searchHistoryEntity) {
 searchHistoryMapper.save(searchHistoryEntity);
    }

    @Override
    public void update(SearchHistoryEntity searchHistoryEntity) {
searchHistoryMapper.update(searchHistoryEntity);
    }

    @Override
    public void delete(Integer id) {
 searchHistoryMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
searchHistoryMapper.deleteBatch(ids);
    }
}
