package com.linjun.service;

import com.linjun.entity.RentEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service
public interface RentServcie {
    RentEntity queryObject(Long id);
    List<RentEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(RentEntity rentEntity);
    void update(RentEntity rentEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
