package com.linjun.service.impl;

import com.linjun.dao.RentMessageMapper;
import com.linjun.entity.RentMessageEntity;
import com.linjun.service.RentMessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/4.
 * @desc
 **/
public class RentMessageServiceImpl implements RentMessageService {
   @Autowired
   private RentMessageMapper rentMessageMapper;
    @Override
    public RentMessageEntity queryObject(Long id) {
        return rentMessageMapper.queryObject(id);
    }

    @Override
    public List<RentMessageEntity> queryList(Map<String, Object> map) {
        return rentMessageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return rentMessageMapper.queryTotal(map);
    }

    @Override
    public void save(RentMessageEntity rentMessageEntity) {
   rentMessageMapper.save(rentMessageEntity);
    }

    @Override
    public void update(RentMessageEntity rentMessageEntity) {
   rentMessageMapper.update(rentMessageEntity);
    }

    @Override
    public void delete(Long id) {
    rentMessageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   rentMessageMapper.deleteBatch(ids);
    }
}
