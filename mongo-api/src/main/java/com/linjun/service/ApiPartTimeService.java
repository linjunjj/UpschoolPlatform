package com.linjun.service;

import com.linjun.entity.PartTimeVo;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
public interface ApiPartTimeService {
    PartTimeVo queryObject(Long id);
    List<PartTimeVo> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(PartTimeVo partTimeVo);
    void update(PartTimeVo partTimeVo);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
