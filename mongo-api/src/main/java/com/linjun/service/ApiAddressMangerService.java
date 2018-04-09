package com.linjun.service;

import com.linjun.entity.AddressMangerVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ApiAddressMangerService {
    AddressMangerVo queryObject(Long id);
    List<AddressMangerVo> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(AddressMangerVo addressMangerVo);
    void  update(AddressMangerVo addressMangerVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}

