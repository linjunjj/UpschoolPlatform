package com.linjun.service.impl;

import com.linjun.dao.ApiRentMessageMapper;
import com.linjun.entity.RentMessageEntity;
import com.linjun.service.ApiRentMessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
public class ApiRentMessageServiceImpl implements ApiRentMessageService {
    @Autowired
    private ApiRentMessageMapper apiRentMessageMapper;
    @Override
    public RentMessageEntity queryObject(Integer id) {
        return apiRentMessageMapper.queryObject(id);
    }

    @Override
    public List<RentMessageEntity> queryList(Map<String, Object> map) {
        return apiRentMessageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiRentMessageMapper.queryTotal(map);
    }

    @Override
    public void save(RentMessageEntity rentMessageEntity) {
  apiRentMessageMapper.save(rentMessageEntity);
    }

    @Override
    public void update(RentMessageEntity rentMessageEntity) {
  apiRentMessageMapper.update(rentMessageEntity);
    }

    @Override
    public void delete(Integer id) {
   apiRentMessageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
   apiRentMessageMapper.deleteBatch(ids);
    }
}
