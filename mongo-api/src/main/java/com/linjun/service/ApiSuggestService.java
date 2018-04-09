package com.linjun.service;

import com.linjun.entity.SuggestVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiSuggestService {
    SuggestVo queryObject(Long id);
    List<SuggestVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SuggestVo suggestVo);
    void update(SuggestVo suggestVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
