package com.linjun.service.impl;

import com.linjun.dao.AddressMangerMapper;
import com.linjun.entity.AddressManger;
import com.linjun.service.AddressMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/3.
 * @desc
 **/
@Service
public class AddressMangerServiceImpl implements AddressMangerService {
    @Autowired
    private AddressMangerMapper addressMangerMapper;
    @Override
    public AddressManger queryObject(Long id) {
        return addressMangerMapper.queryObject(id);
    }

    @Override
    public List<AddressManger> queryList(Map<String, Object> map) {
        return addressMangerMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return addressMangerMapper.queryTotal(map);
    }

    @Override
    public void save(AddressManger addressManger) {
  addressMangerMapper.save(addressManger);
    }

    @Override
    public void update(AddressManger addressManger) {
addressMangerMapper.update(addressManger);
    }

    @Override
    public void delete(Long id) {
addressMangerMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  addressMangerMapper.deleteBatch(ids);
    }
}
