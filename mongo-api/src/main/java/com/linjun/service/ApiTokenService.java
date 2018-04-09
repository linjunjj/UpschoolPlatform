package com.linjun.service;

import com.linjun.entity.TokenVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiTokenService {
    TokenVo queryObject(Long id);
    List<TokenVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(TokenVo tokenVo);
    void update(TokenVo tokenVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
