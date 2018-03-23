package com.linjun.service.impl;

import com.linjun.dao.ApiAddressMangerMapper;
import com.linjun.entity.AddressManger;
import com.linjun.service.ApiAddressMangerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
public class ApiAddressMangerServiceImpl implements ApiAddressMangerService {
    @Autowired
    private ApiAddressMangerMapper apiAddressMangerMapper;

    @Override
    public AddressManger queryObject(Integer id) {


        return apiAddressMangerMapper.queryObject(id);
    }

    @Override
    public List<AddressManger> queryList(Map<String, Object> map) {
        return apiAddressMangerMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiAddressMangerMapper.queryTotal(map);
    }

    @Override
    public void save(AddressManger addressManger) {
          apiAddressMangerMapper.save(addressManger);
    }

    @Override
    public void update(AddressManger addressManger) {
        apiAddressMangerMapper.update(addressManger);
    }

    @Override
    public void delete(Integer id) {
       apiAddressMangerMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
       apiAddressMangerMapper.deleteBatch(ids);
    }
}
