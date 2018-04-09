package com.linjun.service;

import com.linjun.entity.RentCategoryVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiRentCategoryService {
    RentCategoryVo queryObject(Long id);
    List<RentCategoryVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(RentCategoryVo rentCategoryVo) ;
    void update(RentCategoryVo rentCategoryVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
