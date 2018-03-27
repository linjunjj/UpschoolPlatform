package com.linjun.service.impl;

import com.linjun.dao.ApiUserIncomeMapper;
import com.linjun.entity.UserIncomeEntity;
import com.linjun.service.ApiUserIncomeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
public class ApiUserIncomeServiceImpl  implements ApiUserIncomeService{
    @Autowired
    private ApiUserIncomeMapper apiUserIncomeMapper;
    @Override
    public UserIncomeEntity queryObject(Long id) {
        return apiUserIncomeMapper.queryObject(id);
    }

    @Override
    public List<UserIncomeEntity> queryList(Map<String, Object> map) {
        return apiUserIncomeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserIncomeMapper.queryTotal(map);
    }

    @Override
    public void save(UserIncomeEntity userIncomeEntity) {
apiUserIncomeMapper.save(userIncomeEntity);
    }

    @Override
    public void update(UserIncomeEntity userIncomeEntity) {
apiUserIncomeMapper.update(userIncomeEntity);
    }

    @Override
    public void delete(Long id) {
apiUserIncomeMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiUserIncomeMapper.deleteBatch(ids);
    }
}
