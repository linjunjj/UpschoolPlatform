package com.linjun.service;

import com.linjun.entity.SignVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiSignService {
    SignVo queryObject(Long id);
    List<SignVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SignVo signVo);
    void update(SignVo signVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
