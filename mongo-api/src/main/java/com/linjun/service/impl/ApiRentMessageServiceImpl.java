package com.linjun.service.impl;

import com.linjun.dao.ApiRentMessageMapper;
import com.linjun.entity.RentMessageVo;
import com.linjun.service.ApiRentMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service("apiRentMessagesService")
public class ApiRentMessageServiceImpl implements ApiRentMessageService {
    @Autowired
    private ApiRentMessageMapper apiRentMessageMapper;
    @Override
    public RentMessageVo queryObject(Long id) {
        return apiRentMessageMapper.queryObject(id);
    }

    @Override
    public List<RentMessageVo> queryList(Map<String, Object> map) {
        return apiRentMessageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiRentMessageMapper.queryTotal(map);
    }

    @Override
    public void save(RentMessageVo rentMessageVo) {
  apiRentMessageMapper.save(rentMessageVo);
    }

    @Override
    public void update(RentMessageVo rentMessageVo) {
  apiRentMessageMapper.update(rentMessageVo);
    }

    @Override
    public void delete(Long id) {
   apiRentMessageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   apiRentMessageMapper.deleteBatch(ids);
    }
}
