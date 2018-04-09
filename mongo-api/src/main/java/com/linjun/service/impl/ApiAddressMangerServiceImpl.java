package com.linjun.service.impl;

import com.linjun.dao.ApiAddressMangerMapper;
import com.linjun.entity.AddressMangerVo;
import com.linjun.service.ApiAddressMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service("apiAddressMangerService")
public class ApiAddressMangerServiceImpl implements ApiAddressMangerService {
    @Autowired
    private ApiAddressMangerMapper apiAddressMangerMapper;

    @Override
    public AddressMangerVo queryObject(Long id) {


        return apiAddressMangerMapper.queryObject(id);
    }

    @Override
    public List<AddressMangerVo> queryList(Map<String, Object> map) {
        return apiAddressMangerMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiAddressMangerMapper.queryTotal(map);
    }

    @Override
    public void save(AddressMangerVo addressMangerVo) {
          apiAddressMangerMapper.save(addressMangerVo);
    }

    @Override
    public void update(AddressMangerVo addressMangerVo) {
        apiAddressMangerMapper.update(addressMangerVo);
    }

    @Override
    public void delete(Long id) {
       apiAddressMangerMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
       apiAddressMangerMapper.deleteBatch(ids);
    }
}
