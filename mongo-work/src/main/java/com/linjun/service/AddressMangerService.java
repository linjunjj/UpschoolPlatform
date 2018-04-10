package com.linjun.service;

import com.linjun.entity.AddressMangerEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface AddressMangerService {
    AddressMangerEntity queryObject(Long id);
    List<AddressMangerEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(AddressMangerEntity addressMangerEntity);
    void  update(AddressMangerEntity addressMangerEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}

