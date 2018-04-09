package com.linjun.service;

import com.linjun.entity.PartTimeCategoryVo;

import java.util.List;
import java.util.Map;


/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/

public interface ApiPartTimeCategoryService {
    PartTimeCategoryVo queryObject(Long id);
    List<PartTimeCategoryVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(PartTimeCategoryVo partTimeCategoryVo);
    void update(PartTimeCategoryVo partTimeCategoryVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
