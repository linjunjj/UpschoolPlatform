package com.linjun.service.impl;

import com.linjun.dao.ApiUserOrderMapper;
import com.linjun.entity.UserOrderEntity;
import com.linjun.service.ApiUserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiUserOrderService")
public class ApiUserOrderServcieImpl implements ApiUserOrderService {

    @Autowired
    private ApiUserOrderMapper apiUserOrderMapper;
    @Override
    public UserOrderEntity queryObject(Long id) {
        return apiUserOrderMapper.queryObject(id);
    }

    @Override
    public List<UserOrderEntity> queryList(Map<String, Object> map) {
        return apiUserOrderMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserOrderMapper.queryTotal(map);
    }

    @Override
    public void save(UserOrderEntity userOrderEntity) {
  apiUserOrderMapper.save(userOrderEntity);
    }

    @Override
    public void update(UserOrderEntity userOrderEntity) {
  apiUserOrderMapper.update(userOrderEntity);
    }

    @Override
    public void delete(Long id) {
   apiUserOrderMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiUserOrderMapper.deleteBatch(ids);
    }
}
