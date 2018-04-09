package com.linjun.service;

import com.linjun.entity.CodeVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ApiCodeService {
    CodeVo queryObject(Long id);
    List<CodeVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(CodeVo codeVo);
    void update(CodeVo codeVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
