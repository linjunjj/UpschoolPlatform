package com.linjun.service.impl;

import com.linjun.dao.ApiSuggestMapper;
import com.linjun.entity.SuggestVo;
import com.linjun.service.ApiSuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiSuggestService")
public class ApiSuggestServiceImpl implements ApiSuggestService {
    @Autowired
    private ApiSuggestMapper apiSuggestMapper;
    @Override
    public SuggestVo queryObject(Long id) {
        return apiSuggestMapper.queryObject(id);
    }

    @Override
    public List<SuggestVo> queryList(Map<String, Object> map) {
        return apiSuggestMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiSuggestMapper.queryTotal(map);
    }

    @Override
    public void save(SuggestVo suggestVo) {
  apiSuggestMapper.save(suggestVo);
    }

    @Override
    public void update(SuggestVo suggestVo) {
  apiSuggestMapper.update(suggestVo);
    }

    @Override
    public void delete(Long id) {
 apiSuggestMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
 apiSuggestMapper.deleteBatch(ids);
    }
}
