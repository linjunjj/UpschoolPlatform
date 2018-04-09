package com.linjun.service;

import com.linjun.entity.SignDetailVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiSignDetailService {
    SignDetailVo queryObject(Long id);
    List<SignDetailVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SignDetailVo signDetailVo);
    void update(SignDetailVo signDetailVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
