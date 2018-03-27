package com.linjun.service;

import com.linjun.entity.PartTimeCategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service
public interface ApiPartTimeCategoryService {
    PartTimeCategoryEntity queryObject(Long id);
    List<PartTimeCategoryEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(PartTimeCategoryEntity partTimeCategoryEntity);
    void update(PartTimeCategoryEntity partTimeCategoryEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
