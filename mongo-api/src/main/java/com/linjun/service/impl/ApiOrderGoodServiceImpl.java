package com.linjun.service.impl;

import com.linjun.dao.ApiOrderGoodMapper;
import com.linjun.entity.OrderGoodVo;
import com.linjun.service.ApiOrderGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service("apiOrderGoodService")
public class ApiOrderGoodServiceImpl implements ApiOrderGoodService
{
    @Autowired
    private ApiOrderGoodMapper apiOrderGoodMapper;
    @Override
    public OrderGoodVo queryObject(Long id) {
        return apiOrderGoodMapper.queryObject(id);
    }

    @Override
    public List<OrderGoodVo> queryList(Map<String, Object> map) {
        return apiOrderGoodMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiOrderGoodMapper.queryTotal(map);
    }

    @Override
    public void save(OrderGoodVo orderGoodVo) {
        apiOrderGoodMapper.save(orderGoodVo);
    }

    @Override
    public void update(OrderGoodVo orderGoodVo) {
        apiOrderGoodMapper.update(orderGoodVo);
    }

    @Override
    public void delete(Long id) {
    apiOrderGoodMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  apiOrderGoodMapper.deleteBatch(ids);
    }
}
