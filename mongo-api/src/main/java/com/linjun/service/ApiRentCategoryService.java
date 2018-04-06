package com.linjun.service;

import com.linjun.entity.RentCategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface ApiRentCategoryService {
    RentCategoryEntity queryObject(Long id);
    List<RentCategoryEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(RentCategoryEntity rentCategoryEntity) ;
    void update(RentCategoryEntity rentCategoryEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
