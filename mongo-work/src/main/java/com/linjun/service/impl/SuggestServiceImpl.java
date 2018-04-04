package com.linjun.service.impl;

import com.linjun.dao.SuggestMapper;
import com.linjun.entity.SuggestEntity;
import com.linjun.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
public class SuggestServiceImpl implements SuggestService {
    @Autowired
    private SuggestMapper suggestMapper;
    @Override
    public SuggestEntity queryObject(Long id) {
        return suggestMapper.queryObject(id);
    }

    @Override
    public List<SuggestEntity> queryList(Map<String, Object> map) {
        return suggestMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return suggestMapper.queryTotal(map);
    }

    @Override
    public void save(SuggestEntity suggestEntity) {
  suggestMapper.save(suggestEntity);
    }

    @Override
    public void update(SuggestEntity suggestEntity) {
   suggestMapper.update(suggestEntity);
    }

    @Override
    public void delete(Long id) {
   suggestMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
    suggestMapper.deleteBatch(ids);
    }
}
