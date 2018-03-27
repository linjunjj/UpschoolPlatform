package com.linjun.service;

import com.linjun.entity.AddressManger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service
public interface ApiAddressMangerService {
    AddressManger queryObject(Long id);
    List<AddressManger> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(AddressManger addressManger);
    void  update(AddressManger addressManger);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}

