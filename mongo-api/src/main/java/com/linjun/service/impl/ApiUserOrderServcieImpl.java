package com.linjun.service.impl;

import com.linjun.dao.ApiUserOrderMapper;
import com.linjun.entity.UserOrderVo;
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
    public UserOrderVo queryObject(Long id) {
        return apiUserOrderMapper.queryObject(id);
    }

    @Override
    public List<UserOrderVo> queryList(Map<String, Object> map) {
        return apiUserOrderMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserOrderMapper.queryTotal(map);
    }

    @Override
    public void save(UserOrderVo userOrderVo) {
  apiUserOrderMapper.save(userOrderVo);
    }

    @Override
    public void update(UserOrderVo userOrderVo) {
  apiUserOrderMapper.update(userOrderVo);
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
