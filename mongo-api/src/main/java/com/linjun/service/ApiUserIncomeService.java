package com.linjun.service;

import com.linjun.entity.UserIncomeVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface ApiUserIncomeService {
    UserIncomeVo queryObject(Long id);
    List<UserIncomeVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(UserIncomeVo userIncomeVo);
    void update(UserIncomeVo userIncomeVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
