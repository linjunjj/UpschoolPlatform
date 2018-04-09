package com.linjun.service.impl;

import com.linjun.dao.ApiUserIncomeMapper;
import com.linjun.entity.UserIncomeVo;
import com.linjun.service.ApiUserIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiUserIncomeService")
public class ApiUserIncomeServiceImpl  implements ApiUserIncomeService{
    @Autowired
    private ApiUserIncomeMapper apiUserIncomeMapper;
    @Override
    public UserIncomeVo queryObject(Long id) {
        return apiUserIncomeMapper.queryObject(id);
    }

    @Override
    public List<UserIncomeVo> queryList(Map<String, Object> map) {
        return apiUserIncomeMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiUserIncomeMapper.queryTotal(map);
    }

    @Override
    public void save(UserIncomeVo userIncomeVo) {
apiUserIncomeMapper.save(userIncomeVo);
    }

    @Override
    public void update(UserIncomeVo userIncomeVo) {
apiUserIncomeMapper.update(userIncomeVo);
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
