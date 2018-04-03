package com.linjun.service;

import com.linjun.entity.TokenEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service
public interface TokenService {
    TokenEntity queryObject(Long id);
    List<TokenEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(TokenEntity tokenEntity);
    void update(TokenEntity tokenEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
